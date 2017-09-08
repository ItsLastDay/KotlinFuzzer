package ru.au.kotlinfuzzer.mutation

import ru.au.kotlinfuzzer.ast.*
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.ast.entities.*
import ru.au.kotlinfuzzer.fuzzing.FuzzingFriendlyNode
import ru.au.kotlinfuzzer.fuzzing.makeFuzzingFriendly
import ru.au.kotlinfuzzer.fuzzing.makeFuzzingUnfriendly
import ru.au.kotlinfuzzer.generators.*
import java.util.*

private val allPossibleTemplates = listOf(AddNullability(), DeleteNullability(), AddFunctionModifier(),
        AddClassModifier(), RenameVariable(), AddFunctionReceiver(), AddPropertyReceiver(),
        AddNonnullAssertion(), ReplaceExprWithWhen(), ReplaceExprWithIf(), ReplaceExprWithTry(),
        ReplaceExprWithRandomExpr(), ReplaceExprWithElvis(),
        AddReifiedToGeneric(), AddVarianceAnnotationToProjection())
private val random = Random(System.getenv("fixedMutationSeed")?.toLong() ?: System.currentTimeMillis())

inline private fun <reified T> getFFNChild(ffn: ASTNode): T = (ffn as FuzzingFriendlyNode).node as T
inline fun <reified T> getTypedNode(node: ASTNode): T =
        if (node is FuzzingFriendlyNode)
            node.node as T
        else
            node as T

inline fun <reified T> getTypedList(lst: List<ASTNode>): List<T> = lst.map { getTypedNode<T>(it) }

/**
 * Base class for all fuzz-related changes in AST.
 *
 * We can modify existing AST with FuzzingFriendlyNode-s to
 * obtain many Kotlin programs.
 *
 * Every modification should transform a subtree (possible, a subset
 * of a subtree). Otherwise, it would be too troublesome to write
 * `apply` and `canBeApplied` functions: we must know in what node
 * of a pattern do we stand now. If we stand in the root node,
 * everything is well-understood.
 *
 * WARNING: you should not use `xxxTyped` properties of ASTNode-s!
 * They are initialized at node startup and may point to old data.
 */
abstract class MutationTemplate {
    // Can this template be applied at the `node` as root?
    abstract fun canBeApplied(node: FuzzingFriendlyNode): Boolean

    // Apply the mutation, with `node` being the root node.
    abstract fun apply(node: FuzzingFriendlyNode)

    // Probability of choosing the exact mutation is `weight` / W
    // where W = sum of all `weight`-s of mutations
    // applicable to the current node.
    abstract val weight: Long

    // If this mutation is chosen, then run it with probability `occurProbability`.
    abstract val occurProbability: Double
}

class AddNullability : MutationTemplate() {
    override fun canBeApplied(node: FuzzingFriendlyNode): Boolean {
        if (node.node is KotlinType && node.node !is NullableType)
            return node.nodeParent !is KotlinType
                    && node.nodeParent !is CallableReferenceNode // Too many crashing tests with callable ref-s
        return false
    }

    override fun apply(node: FuzzingFriendlyNode) {
        // FuzzingFriendlyNode(x) -> KotlinType(y)
        // changes to
        // FuzzingFriendlyNode(x) -> NullableType -> FuzzingFriendlyNode -> KotlinType(y)
        val type = node.node!!
        makeFuzzingFriendly(NullableType(type), node)
    }

    override val weight = 10L
    override val occurProbability: Double = 0.15
}


class DeleteNullability() : MutationTemplate() {
    override fun canBeApplied(node: FuzzingFriendlyNode): Boolean {
        return node.node is NullableType
    }

    override fun apply(node: FuzzingFriendlyNode) {
        // FuzzingFriendlyNode(x) -> NullableType -> FuzzingFriendlyNode -> KotlinType(y)
        // changes to
        // FuzzingFriendlyNode(x) -> KotlinType(y)
        val nullable = getFFNChild<NullableType>(node)
        val inner =  getFFNChild<KotlinType>(nullable.innerType)
        node.node = inner
    }

    override val weight = 5L
    override val occurProbability: Double = 0.10
}

abstract class AddModifiersBase : MutationTemplate() {
    abstract protected val possibleModifiers: List<String>
    abstract protected val parentClass: Class<*>

    override fun canBeApplied(node: FuzzingFriendlyNode): Boolean {
        if (node.node is ModifiersNode) {
            return parentClass.isInstance(node.nodeParent)
                    && !getFFNChild<ModifiersNode>(node).rawModifiersAnnotations.containsAll(possibleModifiers)
        }

        return false
    }

    override fun apply(node: FuzzingFriendlyNode) {
        val mods = getFFNChild<ModifiersNode>(node)
        val filteredPossible = possibleModifiers.filter{ !mods.rawModifiersAnnotations.contains(it) }
        val choice = random.nextInt(filteredPossible.size)
        node.node = ModifiersNode(mods.rawModifiersAnnotations + listOf(filteredPossible[choice]))
    }
}

class AddVarianceAnnotationToProjection() : AddModifiersBase() {
    override val weight: Long
        get() = 7
    override val occurProbability: Double
        get() = 0.01
    override val possibleModifiers: List<String>
        get() = listOf("in", "out")
    override val parentClass: Class<*>
        get() = TypeProjection::class.java
}

class AddFunctionModifier() : AddModifiersBase() {
    override val possibleModifiers = listOf("tailrec", "operator", "infix",
            "inline", "external", "suspend")
    override val parentClass = FunctionDeclarationNode::class.java
    override val weight = 15L
    override val occurProbability: Double = 0.15
}

class AddClassModifier() : AddModifiersBase() {
    override val possibleModifiers = listOf("abstract", "final", "enum",
            "open", "annotation", "sealed", "data", "inner")
    override val parentClass = ClassDeclarationNode::class.java
    override val weight = 10L
    override val occurProbability: Double = 0.20
}

class RenameVariable() : MutationTemplate() {
    override fun canBeApplied(node: FuzzingFriendlyNode): Boolean {
        return (node.node is VariableUsageNode
                || node.node is VariableDeclaration) && node.nodeScope != null
    }

    override fun apply(node: FuzzingFriendlyNode) {
        val nameToPut = node.nodeScope!!.allEntities.run {
            val index = random.nextInt(size)
            get(index).name
        }
        when (node.node) {
            is VariableUsageNode -> node.node = VariableUsageNode(nameToPut)
            is VariableDeclaration -> node.node = VariableDeclaration(nameToPut, getFFNChild<VariableDeclaration>(node).type)
            else -> throw IllegalArgumentException("unknown node for RenameVariable mutation")
        }
    }

    override val weight = 5L
    override val occurProbability: Double = 0.005
}

abstract class AddReceiver() : MutationTemplate() {
    abstract val parentClass: Class<*>

    override fun canBeApplied(node: FuzzingFriendlyNode): Boolean {
        return (parentClass.isInstance(node.node)
                && (getFFNChild<WithReceiver>(node).receiverType as FuzzingFriendlyNode).node == null
                && node.nodeScope != null)
    }

    override fun apply(node: FuzzingFriendlyNode) {
        (getFFNChild<WithReceiver>(node).receiverType as FuzzingFriendlyNode).node = generateType(node.nodeScope!!)
    }
}

class AddFunctionReceiver() : AddReceiver() {
    override val parentClass = FunctionDeclarationNode::class.java

    override val weight: Long
        get() = 7
    override val occurProbability: Double
        get() = 0.05
}


class AddPropertyReceiver() : AddReceiver() {
    override val parentClass = PropertyDeclarationNode::class.java

    override val weight: Long
        get() = 10
    override val occurProbability: Double
        get() = 0.01
}

/**
 * expr -> (expr)!!
 */
class AddNonnullAssertion() : MutationTemplate() {
    override fun canBeApplied(node: FuzzingFriendlyNode): Boolean {
        return node.node is ExpressionNode &&
                node.nodeParent is ExpressionNode &&
                (node.node !is PostfixUnaryNode ||
                        getFFNChild<PostfixUnaryNode>(node).type != PostfixUnaryOpType.NOT_NULL)
    }

    override fun apply(node: FuzzingFriendlyNode) {
        // FuzzingFriendlyNode(x) -> ExpressionNode(y)
        // changes to
        // FuzzingFriendlyNode(x) -> PostfixUnaryNode -> FuzzingFriendlyNode -> ParenthizedExpressionNode -> FuzzingFriendlyNode -> ExpressionNode(y)
        val origExpr = node.node!!
        makeFuzzingFriendly(PostfixUnaryNode(ParenthizedExpressionNode(origExpr), PostfixUnaryOpType.NOT_NULL),
                node)
    }

    override val weight: Long
        get() = 3
    override val occurProbability: Double
        get() = 0.07
}

/**
 * expr -> SomeStatementWithSameMeaning(expr)
 * e.g. expr -> if (true) expr else expr
 */
abstract class ReplaceExprWithStmtexpr() : MutationTemplate() {
    override fun canBeApplied(node: FuzzingFriendlyNode): Boolean {
        return node.node is ExpressionNode &&
                node.nodeParent is ExpressionNode
    }

    override val weight: Long
        get() = 15
    override val occurProbability: Double
        get() = 0.01

}

/**
 * expr -> (when {
 *  random_bool -> expr
 *  else -> generated_expr_with_same_type
 * })
 */
class ReplaceExprWithWhen() : ReplaceExprWithStmtexpr() {
    override fun apply(node: FuzzingFriendlyNode) {
        val origExpr = ParenthizedExpressionNode(node.node!!)
        val entries = listOf(
                WhenEntry(listOf(WhenConditionExpr(
                        generateRandomBooleanExpr(origExpr)
                        )),
                        origExpr),
                WhenEntry(listOf(WhenConditionElse()),
                        generateExpressionTypedAs(origExpr as ExpressionNode))
        )
        val whenNode = WhenNode(null, entries)
        makeFuzzingFriendly(ParenthizedExpressionNode(whenNode), node)
    }

    override val weight: Long
        get() = 25
}

/**
 * expr -> (if (generated_boolean_expr) expr else generated_expr)
 */
class ReplaceExprWithIf() : ReplaceExprWithStmtexpr() {
    override fun apply(node: FuzzingFriendlyNode) {
        val origExpr = ParenthizedExpressionNode(node.node!!)
        val condition = generateRandomBooleanExpr(origExpr)
        val ifNode = IfNode(condition, origExpr, generateExpressionTypedAsOrRandom(origExpr))
        makeFuzzingFriendly(ParenthizedExpressionNode(ifNode), node)
    }

    override val weight: Long
        get() = 4L
    override val occurProbability: Double
        get() = 0.0
}

/**
 * expr -> (try { expr } finally { expr })
 */
class ReplaceExprWithTry() : ReplaceExprWithStmtexpr() {
    override fun apply(node: FuzzingFriendlyNode) {
        val origExpr = node.node!!
        val code = StatementsNode(listOf(origExpr))
        val tryNode = TryNode(code,
                listOf(),
                code)
        makeFuzzingFriendly(ParenthizedExpressionNode(tryNode), node)
    }

    override val weight: Long
        get() = 5L
}

/**
 * expr -> expr ?: expr
 */
class ReplaceExprWithElvis() : ReplaceExprWithStmtexpr() {
    override fun apply(node: FuzzingFriendlyNode) {
        val origExpr = ParenthizedExpressionNode(node.node!!)
        val elvis = BinaryOpNode(origExpr, origExpr, BinaryOpType.ELVIS)
        makeFuzzingFriendly(ParenthizedExpressionNode(elvis), node)
    }

    override val occurProbability: Double
        get() = 0.0
}

class ReplaceExprWithRandomExpr() : ReplaceExprWithStmtexpr() {
    override fun apply(node: FuzzingFriendlyNode) {
        makeFuzzingFriendly(ParenthizedExpressionNode(generateRandomExpression()), node)
    }

    override val weight = 5L
    override val occurProbability: Double
        get() = 0.0001
}

/**
 * If function is inline and has generic types, add "reified" modifier to that type.
 */
class AddReifiedToGeneric() : MutationTemplate() {
    private fun isNotReifiedType(type: KotlinType): Boolean {
        if (type !is TypeProjection)
            return true
        return !getTypedNode<ModifiersNode>(type.modifiers).rawModifiersAnnotations.contains("reified")
    }

    override fun canBeApplied(node: FuzzingFriendlyNode): Boolean {
        if (node.node !is FunctionDeclarationNode)
            return false
        val func = getFFNChild<FunctionDeclarationNode>(node)
        if (!getTypedNode<ModifiersNode>(func.modifiers).rawModifiersAnnotations.contains("inline"))
            return false
        if ((func.genericParams as FuzzingFriendlyNode).node == null)
            return false
        return getTypedNode<GenericTypeParams>(func.genericParams).types.any { isNotReifiedType(getFFNChild<KotlinType>(it)) }
    }

    override fun apply(node: FuzzingFriendlyNode) {
        val func = getFFNChild<FunctionDeclarationNode>(node)
        val generics = getTypedNode<GenericTypeParams>(func.genericParams!!)
        val appliableFFN = generics.types.findLast {
            isNotReifiedType(getFFNChild<KotlinType>(it))
        }

        if ((appliableFFN as FuzzingFriendlyNode).node is SimpleType)
            makeFuzzingFriendly(TypeProjection(ModifiersNode(listOf("reified")), appliableFFN.node, null), node)
        else if (appliableFFN.node is TypeProjection) {
            val modifiersFFN = getFFNChild<TypeProjection>(appliableFFN).modifiers as FuzzingFriendlyNode
            makeFuzzingFriendly(ModifiersNode(getFFNChild<ModifiersNode>(modifiersFFN).rawModifiersAnnotations + listOf("reified")),
                    modifiersFFN)
        } else {
            throw IllegalStateException()
        }
    }

    override val weight: Long
        get() = 15
    override val occurProbability: Double
        get() = 0.05

}

/**
 * Populate FuzzingFriendlyNode states by mutating\changing AST.
 */
class ASTFuzzer(val visitorPossibleTemplates: List<MutationTemplate>) : ASTNodeVisitor<Unit, Unit> {
    var maxMutations = 100L

    override fun defaultValue(node: ASTNode, data: Unit) {
        node.acceptChildren(this, data)
    }

    override fun visit(node: FuzzingFriendlyNode, data: Unit) {
        if (maxMutations > 0) {
            // Weighted reservoir sampling per
            // http://timvieira.github.io/blog/post/2014/08/01/gumbel-max-trick-and-weighted-reservoir-sampling/
            var chosenMutation: MutationTemplate? = null
            var bestScore = Double.NEGATIVE_INFINITY

            visitorPossibleTemplates
                    .filter { it.canBeApplied(node) }
                    .forEach {
                        val uniform01 = random.nextDouble()
                        val score = Math.log(uniform01) / it.weight
                        if (score > bestScore) {
                            bestScore = score
                            chosenMutation = it
                        }
                    }

            // Do the chosen mutation (if there was any applicable one) with certain probability
            if (chosenMutation != null && random.nextFloat() < chosenMutation!!.occurProbability) {
                --maxMutations
                chosenMutation!!.apply(node)
                node.accept(this, data)
                return
            }
        }

        node.node?.accept(this, Unit)
    }
}

private fun runMutation(ast: ASTNode, templates: List<MutationTemplate>): Iterator<ASTNode> {
    val ffast = makeFuzzingFriendly(ast)
    return object : Iterator<ASTNode> {
        var numIterations = 0
        override fun hasNext(): Boolean {
            return numIterations < 250
        }


        override fun next(): ASTNode {
            ffast.accept(ASTFuzzer(templates), Unit)
            numIterations++
            val plainAST = makeFuzzingUnfriendly(ffast)!!
            ffast.rollbackToOriginal()
            return plainAST
        }

    }
}

fun mutateAST(ast: ASTNode): Iterator<ASTNode> = runMutation(ast, allPossibleTemplates)

fun mutateASTWith(ast: ASTNode, templates: List<MutationTemplate>) = runMutation(ast, templates)

/**
 * Behaves as `mutateAST` but without applying any rules.
 * Can be used to test whether fuzzing process itself changes anything.
 */
fun mutateASTShallow(ast: ASTNode): ASTNode = runMutation(ast, emptyList()).next()

fun minimize(ast: ASTNode): ASTNode {
    return ast
}

fun buildFuzzingFriendlyASTFromFile(filename: String): FuzzingFriendlyNode {
    val ast = buildASTFromFile(filename)
    return makeFuzzingFriendly(ast)
}
