package ru.au.kotlinfuzzer.scope

import ru.au.kotlinfuzzer.ast.*
import ru.au.kotlinfuzzer.ast.entities.KotlinType
import ru.au.kotlinfuzzer.ast.entities.SimpleType
import ru.au.kotlinfuzzer.ast.entities.VariableDeclaration

private class Stack <T> {
    var contents = arrayListOf<T>()

    fun top(): T = contents.last()
    fun push(elem: T) = contents.add(elem)
    fun pop() = contents.run { removeAt(lastIndex) }
}

private val stdlibTypes = listOf("Any", "Unit", "Int",
        "String", "Double").map { SimpleType(it) }


data class Scope(
        val parentScope: Scope?,
        val variables: List<VariableDeclaration>,
        val classes: List<ClassDeclarationNode>,
        val functions: List<FunctionDeclarationNode>,
        val objects: List<ObjectNode>,
        val types: List<KotlinType>
) {
    companion object {
        fun getEmptyScopeWithParent(parent: Scope?): Scope
            = Scope(parent, emptyList(), emptyList(), emptyList(), emptyList(), emptyList())

        val EMPTY_SCOPE = getEmptyScopeWithParent(null).let {
            var scope = it
            for (type in stdlibTypes)
                scope = scope.withAddedType(type)
            scope
        }
    }

    fun withAddedFunction(func: FunctionDeclarationNode): Scope = Scope(parentScope, variables, classes, functions + listOf(func), objects, types)
    fun withAddedVariable(prop: VariableDeclaration): Scope = Scope(parentScope, variables + listOf(prop), classes, functions, objects, types)
    fun withAddedClass(cls: ClassDeclarationNode): Scope = Scope(parentScope, variables, classes + listOf(cls), functions, objects, types)
    fun withAddedObject(obj: ObjectNode): Scope = Scope(parentScope, variables, classes, functions, objects + listOf(obj), types)
    fun withAddedType(obj: KotlinType): Scope = Scope(parentScope, variables, classes, functions, objects, types + listOf(obj))

    fun withAddedEntity(node: NamedDeclaration) =
        when (node) {
            is FunctionDeclarationNode -> withAddedFunction(node)
            is VariableDeclaration -> withAddedVariable(node)
            is ClassDeclarationNode -> withAddedClass(node)
            is ObjectNode -> withAddedObject(node)
            else -> throw IllegalArgumentException("Unknown entity to add to scope")
        }

    val declaredEntities: List<NamedDeclaration> =
            (variables as List<NamedDeclaration>) + classes + functions + objects
    val allEntities: List<NamedDeclaration> by lazy {
        declaredEntities + (parentScope?.allEntities ?: emptyList())
    }

    val allTypes: List<KotlinType> by lazy {
        types + (parentScope?.allTypes ?: emptyList())
    }
    // TODO: getFuncByName (with overloads), getVarByName, getEntityByName, ...
    // TODO: clone, getEnclosingScope, ...
}

enum class ScopeComputationMode {
    /**
     * New scope is being populated now.
     *
     * E.g. when computing scope for class members, we need
     * to visit every one of them, so they "register" themselves
     * in the current scope.
     * When this is done, we can do a second pass to set `scope` of
     * each node to the computed scope.
     *
     * When scope is being prepared, no child scopes may be constructed.
     */
    PREPARE,
    /**
     * Scope is ready - write it to ASTNode-s; populate children of this scope.
     */
    APPLY
}

private enum class ScopeNodeType {
    /**
     * Sequential computation of scope - e.g. in function body
     *
     * fun foo() {
     *   val x = 1 // here, `y` is not visible
     *   val y = 4
     * }
     */
    SEQUENTIAL,

    /**
     * Parallel computation of scope, when members are equal - e.g. in class body
     *
     * class A {
     *  fun foo() = 4 // `bar` is visible here
     *  fun bar() = 5
     * }
     */
    PARALLEL
}

/**
 * Populate `scope` property of each node in AST.
 *
 * Does not necessarily follow kotlin scoping rules.
 */
class ScopeComputeVisitor : ASTNodeVisitor<Unit, ScopeComputationMode> {
    private val scopeStack = Stack<Scope>().apply {
        push(Scope.EMPTY_SCOPE)
    }

    private fun registerEntity(node: NamedDeclaration) {
        scopeStack.apply {
            val newScope = top().withAddedEntity(node)
            pop()
            push(newScope)
        }
    }

    private fun visitSomeEntity(node: NamedDeclaration, data: ScopeComputationMode) {
        if (data == ScopeComputationMode.PREPARE) {
            registerEntity(node)
        }
        defaultValue(node as ASTNode, data)
    }

    private fun withAddedScope(node: ASTNode, block: () -> Unit) {
        scopeStack.apply {
            node.scope = top()
            push(Scope.getEmptyScopeWithParent(top()))
        }

        block()

        scopeStack.pop()
    }

    private fun visitNewScope(node: ASTNode, data: ScopeComputationMode,
                              scopeType: ScopeNodeType) {
        when (data) {
            ScopeComputationMode.PREPARE -> {
                return
            }
            ScopeComputationMode.APPLY -> {
                withAddedScope(node, {
                    when (scopeType) {
                        ScopeNodeType.SEQUENTIAL -> {
                            for (child in node.children) {
                                child.accept(this, ScopeComputationMode.PREPARE)
                                child.accept(this, ScopeComputationMode.APPLY)
                            }
                        }
                        ScopeNodeType.PARALLEL -> {
                            for (child in node.children) {
                                child.accept(this, ScopeComputationMode.PREPARE)
                            }

                            for (child in node.children) {
                                child.accept(this, ScopeComputationMode.APPLY)
                            }
                        }
                    }
                })
            }
        }
    }

    override fun visit(node: MembersNode, data: ScopeComputationMode) {
        visitNewScope(node, data, ScopeNodeType.PARALLEL)
    }

    override fun visit(node: StatementsNode, data: ScopeComputationMode) {
        visitNewScope(node, data, ScopeNodeType.SEQUENTIAL)
    }

    override fun defaultValue(node: ASTNode, data: ScopeComputationMode) {
        if (data == ScopeComputationMode.APPLY) {
            node.scope = scopeStack.top()
        }
        node.acceptChildren(this, data)
    }


    override fun visit(node: VariableDeclaration, data: ScopeComputationMode) {
        visitSomeEntity(node, data)
    }

    override fun visit(node: ObjectNode, data: ScopeComputationMode) {
        visitSomeEntity(node, data)
    }

    override fun visit(node: ClassDeclarationNode, data: ScopeComputationMode) {
        visitSomeEntity(node, data)
    }

    override fun visit(node: FunctionDeclarationNode, data: ScopeComputationMode) {
        // If mode is `PREPARE`, we need to add only the function to scope.
        // When mode is `APPLY`, we need to add all arguments, so that they are visible in body.
        when (data) {
            ScopeComputationMode.PREPARE -> {
                registerEntity(node)
            }
            ScopeComputationMode.APPLY -> {
                node.run {
                    modifiers.accept(this@ScopeComputeVisitor, data)
                    genericParams?.accept(this@ScopeComputeVisitor, data)
                    receiverType?.accept(this@ScopeComputeVisitor, data)
                    returnType?.accept(this@ScopeComputeVisitor, data)
                    withAddedScope(node, {
                        arguments.forEach { it.accept(this@ScopeComputeVisitor, ScopeComputationMode.PREPARE) }
                        arguments.forEach { it.accept(this@ScopeComputeVisitor, ScopeComputationMode.APPLY) }
                        body?.accept(this@ScopeComputeVisitor, data)
                    })
                }
            }
        }
    }

    override fun visit(node: ForLoopNode, data: ScopeComputationMode) {
        // Iff mode is `APPLY`, start new scope with variable declarations added.
        // Otherwise, do nothing, because loop does not add any entities.
        if (data == ScopeComputationMode.APPLY) {
            node.inExpr.accept(this, data)
            withAddedScope(node, {
                node.varDeclarations.forEach { it.accept(this, ScopeComputationMode.PREPARE) }
                node.varDeclarations.forEach { it.accept(this, ScopeComputationMode.APPLY) }
                node.body.accept(this, data)
            })
        }
    }

    override fun visit(node: FunctionLiteralNode, data: ScopeComputationMode) {
        // Iff mode is `APPLY`, start new scope with variable declarations added.
        // Otherwise, do nothing, because loop does not add any entities.
        if (data == ScopeComputationMode.APPLY) {
            withAddedScope(node, {
                node.parameters.forEach { it.accept(this, ScopeComputationMode.PREPARE) }
                node.parameters.forEach { it.accept(this, ScopeComputationMode.APPLY) }
                node.statements.accept(this, data)
            })
        }
    }
}


fun computeScope(ast: ASTNode) {
    ast.accept(ScopeComputeVisitor(), ScopeComputationMode.APPLY)
}