package ru.au.kotlinfuzzer.ast

import ru.au.kotlinfuzzer.ast.entities.ValueArgument
import ru.au.kotlinfuzzer.mutation.getTypedList


enum class BinaryOpType {
    MULTIPLY, DIVIDE, MODULO, // Multiplicative
    ADD, SUB, // Additive
    RANGE, // ".."
    ELVIS, // "?:"
    IN, NOT_IN, // In
    LT, GT, LE, GE, // Comparison
    EQ, NOT_EQ, // Equality
    REF_EQ, NOT_REF_EQ, // Referential equality
    AND, OR, // Logical
    ASSIGN, ADD_ASSIGN, SUB_ASSIGN, MULTIPLY_ASSIGN, DIVIDE_ASSIGN, MODULO_ASSIGN // Assignment
}

enum class AsIsType {
    IS, NOT_IS, // Is
    AS, AS_QUEST, COLON // Type operations
}

enum class PrefixUnaryOpType {
    NEG, POS,
    INCREMENT, DECREMENT,
    NOT,
    ANNOTATION,
    LABEL
}

enum class PostfixUnaryOpType {
    INCREMENT, DECREMENT,
    NOT_NULL
}

data class ParenthizedExpressionNode(
        val innerExpr: ASTNode // ExpressionNode
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(innerExpr)
}

class BinaryOpNode(
        val left: ASTNode, // ExpressionNode
        val right: ASTNode, // ExpressionNode
        val type: BinaryOpType
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(left, right)
}

class AsIsOperation(
        val expr: ASTNode, // ExpressionNode
        val type: ASTNode, // KotlinType
        val kind: AsIsType
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr, type)
}

data class VariableUsageNode(val name: String): ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

data class ThisNode(val label: String?) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

data class SuperNode(
        val type: ASTNode?, // KotlinType
        val label: String?
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(type).filterNotNull()
}

data class PrefixUnaryOpNode(
        val expr: ASTNode,
        val type: PrefixUnaryOpType,
        val annotations: ASTNode?,
        val labelName: String?
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr)
}

data class PostfixUnaryNode(
        val expr: ASTNode, // ExpressionNode
        val type: PostfixUnaryOpType
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr)
}

data class ArrayAccessNode(
        val arr: ASTNode,
        val expressions: List<ASTNode> // List<ExpressionNode>
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(arr) + expressions
}

class WhenNode(
        val expr: ASTNode?, // ExpressionNode?
        val entries: List<ASTNode> // List<WhenEntry>
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr).filterNotNull() + entries
}

data class TryNode(
        val code: ASTNode, // CodeBlockNode
        val catchBlocks: List<ASTNode>, // List<CatchBlock>
        val finallyBlock: ASTNode? // CodeBlockNode?
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(finallyBlock, code).filterNotNull() + catchBlocks
}

data class IfNode(
        val condExpr: ASTNode, // ExpressionNode
        val thenBlock: ASTNode?, //CodeBlockNode?
        val elseBlock: ASTNode? // CodeBlockNode?
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(condExpr, thenBlock, elseBlock).filterNotNull()
}

abstract class CallNode : ExpressionNode() {
}

enum class MemberAccessType {
    DOT, // '.'
    SAFE // '?.'
}

class MemberAccessNode(
        val obj: ASTNode,
        val member: ASTNode,
        val type: MemberAccessType
) : CallNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(obj, member)
}

class FunctionCallNode(
        val func: ASTNode,
        val typeArgs: List<ASTNode>, // List<KotlinType>
        val args: List<ASTNode> // List<ValueArgument> or List<FunctionLiteralNode>
) : CallNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(func) + args

    val argsTypedVA by lazy { getTypedList<ValueArgument>(args) }
    val argsTypedFL by lazy { getTypedList<FunctionLiteralNode>(args) }
}

class InfixCallNode(
    val funcName: String,
    val argLeft: ASTNode, // ExpressionNode
    val argRight: ASTNode // ExpressionNode
) : CallNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(argLeft, argRight)
}

data class LiteralConstantNode(val body: String) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

class NotImplementedExpressionNode(val initialText: String) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

class ObjectLiteralNode(
    val members: ASTNode?,
    val delegationSpecifiers: ASTNode?
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(members, delegationSpecifiers).filterNotNull()
}

enum class LoopJumpNodeType {
    CONTINUE, BREAK
}

abstract class JumpNode() : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
}

data class ThrowNode(
        val expr: ASTNode // FunctionDeclarationNode
) : JumpNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr)
}

data class ReturnNode(
    val label: String?,
    val expr: ASTNode? // ExpressionNode?
) : JumpNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr).filterNotNull()
}

data class LoopJumpNode(
    val jumpType: LoopJumpNodeType,
    val label: String?
) : JumpNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = emptyList<ASTNode>()
}

abstract class LoopNode() : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
}

data class ForLoopNode(
        val varDeclarations: List<ASTNode>, // List<VariableDeclaration>
        val inExpr: ASTNode, // ExpressionNode
        val body: ASTNode // CodeBlockNode
) : LoopNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(inExpr, body) + varDeclarations
}

enum class WhileLoopType {
    WHILE, DO_WHILE
}

data class WhileLoopNode(
    val loopType: WhileLoopType,
    val expr: ASTNode, // ExpressionNode
    val body: ASTNode? // CodeBlockNode?
) : LoopNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr, body).filterNotNull()
}

class FunctionLiteralNode(
    val statements: ASTNode, // CodeBlockNode
    val parameters: List<ASTNode> // List<VariableDeclaration>
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(statements) + parameters
}

data class CallableReferenceNode(
        val name: String,
        val type: ASTNode? // KotlinType?; also may be an expression
) : ExpressionNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(type).filterNotNull()
}