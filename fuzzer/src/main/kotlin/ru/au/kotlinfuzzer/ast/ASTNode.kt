package ru.au.kotlinfuzzer.ast

import ru.au.kotlinfuzzer.ast.entities.*
import ru.au.kotlinfuzzer.mutation.getTypedList
import ru.au.kotlinfuzzer.mutation.getTypedNode
import ru.au.kotlinfuzzer.scope.Scope

/**
 * Base class for all Abstract Syntax Tree nodes.
 */
abstract class ASTNode {
    abstract fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D): R

    open var parent: ASTNode? = null
    open var scope: Scope? = null

    // All ASTNodes that this node links to, in no particular order.
    abstract val children: List<ASTNode>

    fun <R, D> acceptChildren(visitor: ASTNodeVisitor<R, D>, data: D): R? {
        for (child in children) {
            child.accept(visitor, data)
        }
        return null
    }
}

/**
 * Stub for not (yet) implemented nodes.
 */
class NotImplementedNode(val initialText: String) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

data class KotlinFileNode(
        val members: ASTNode // MembersNode
) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(members)

    val membersTyped = getTypedNode<MembersNode>(members)
}

/**
 * Top-level, class and object members.
 */
data class MembersNode(override val children: List<ASTNode>) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
}

data class PackageNode(val name: String) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

data class ImportNode(
        val name: String,
        val alias: String?,
        val isImportAll: Boolean = false) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

data class FunctionDeclarationNode(
        val modifiers: ASTNode, // ModifiersNode
        val genericParams: ASTNode?,
        override val name: String,
        override val receiverType: ASTNode?, // KotlinType?
        val returnType: ASTNode?, // KotlinType?
        val arguments: List<ASTNode>, // List<FunctionArgument>
        val body: ASTNode?, // CodeBlockNode?
        val whereConstraints: ASTNode // WhereConstraints
) : ASTNode(),
    NamedDeclaration,
    WithReceiver {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(receiverType, returnType, body, modifiers, genericParams,
            whereConstraints).filterNotNull() + arguments

    val modifiersTyped = getTypedNode<ModifiersNode>(modifiers)
    val argumentsTyped = getTypedList<FunctionArgument>(arguments)
    val whereConstraintsTyped = getTypedNode<WhereConstraints>(whereConstraints)
}

enum class PropertyType {
    VAL, VAR
}

enum class PropertyDelegationType {
    NONE, BY, EQ
}

data class PropertyDeclarationNode(
        val modifiers: ASTNode,
        val propType: PropertyType,
        val propDelegationType: PropertyDelegationType,
        override val receiverType: ASTNode?, // KotlinType?
        val varDecl: List<ASTNode>, // List<VariableDeclaration>
        val initExpr: ASTNode?, // ExpressionNode?
        val whereConstraints: ASTNode, // WhereConstraints
        val getter: ASTNode?,
        val setter: ASTNode?,
        val genericParams: ASTNode? // GenericTypeParams?
) : ASTNode(),
    WithReceiver {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(modifiers, receiverType, initExpr, whereConstraints,
    getter, setter).filterNotNull() + varDecl

    val varDeclTyped = getTypedList<VariableDeclaration>(varDecl)
    val whereConstraintsTyped = getTypedNode<WhereConstraints>(whereConstraints)
}

enum class ClassNodeType {
    CLASS, INTERFACE
}

data class ClassDeclarationNode(
        val modifiers: ASTNode, // ModifiersNode
        override val name: String,
        val nodeType: ClassNodeType,
        val primaryConstructor: ASTNode?,
        val body: ASTNode?,
        val delegationSpecifiers: ASTNode?,
        val typeParams: ASTNode?,
        val whereConstraints: ASTNode // WhereConstraints
) : ASTNode(),
    NamedDeclaration {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(body, modifiers,
            primaryConstructor, typeParams, delegationSpecifiers, whereConstraints).filterNotNull()

    val modifiersTyped = getTypedNode<ModifiersNode>(modifiers)
    val whereConstraintsTyped = getTypedNode<WhereConstraints>(whereConstraints)
}

data class TypealiasNode(
        val name: String,
        val type: ASTNode, // KotlinType
        val genericParams: ASTNode? // GenericTypeParams?
) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(type, genericParams).filterNotNull()
}

data class ObjectNode(
        override val name: String,
        val body: ASTNode?,
        val delegationSpecifiers: ASTNode?
) : ASTNode(),
    NamedDeclaration {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(body, delegationSpecifiers).filterNotNull()
}


abstract class ExpressionNode : ASTNode() {
    open var exprType : KotlinType = UndefinedType() // TODO: override in descendants. Maybe use delegated variables for laziness
        get
        set
}

abstract class CodeBlockNode : ASTNode() {
}

data class StatementsNode(override val children: List<ASTNode>) : CodeBlockNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
}

data class BlockExpressionNode(
        val expr: ASTNode // ExpressionNode
) : CodeBlockNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr)
}

data class CatchBlock(
    val code: ASTNode, // CodeBlockNode
    val varName: String,
    val varType: ASTNode // KotlinType
) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(code, varType)
}

data class WhenEntry(
    val conditions: List<ASTNode>, // List<WhenCondition>
    val code: ASTNode // CodeBlockNode
) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = conditions

    val conditionsTyped = getTypedList<WhenCondition>(conditions)
}


abstract class WhenCondition() : ASTNode() {
}

data class WhenConditionIn(
    val expr: ASTNode, // ExpressionNode
    val negated: Boolean
) : WhenCondition() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr)
}

data class WhenConditionIs(
    val type: ASTNode, // KotlinType
    val negated: Boolean
) : WhenCondition() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(type)
}

data class WhenConditionExpr(
    val expr: ASTNode // ExpressionNode
) : WhenCondition() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr)
}

class WhenConditionElse() : WhenCondition() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

class ModifiersNode(val rawModifiersAnnotations: List<String>) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

class WhereConstraints(
        val constraints: List<ASTNode> // List<VariableDeclaration>
) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = constraints

    val constraintsTyped = getTypedList<VariableDeclaration>(constraints)
}

/**
 * Generic params of functions, classes, etc.
 * e.g. "<T, R>" in "fun <T, R> foo() = 1"
 */
class GenericTypeParams(
        val types: List<ASTNode> // List<KotlinType>
) : ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = types

    val typesTyped = getTypedList<KotlinType>(types)
}