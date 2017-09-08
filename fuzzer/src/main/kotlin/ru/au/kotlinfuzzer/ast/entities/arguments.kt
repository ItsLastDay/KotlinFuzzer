package ru.au.kotlinfuzzer.ast.entities

import org.antlr.v4.runtime.tree.ParseTree
import ru.au.kotlinfuzzer.ast.ASTNode
import ru.au.kotlinfuzzer.ast.ASTNodeVisitor
import ru.au.kotlinfuzzer.ast.builders.FunctionArgumentBuilder
import ru.au.kotlinfuzzer.ast.builders.ValueArgumentBuilder
import ru.au.kotlinfuzzer.mutation.getTypedNode


/**
 * Argument in a function definition.
 *
 * Has at least: type, name, default value.
 */
data class FunctionArgument(
        val varDecl: ASTNode, // VariableDeclaration
        val defaultValue: ASTNode? // ExpressionNode?
): ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(varDecl, defaultValue).filterNotNull()

    val varDeclTyped = getTypedNode<VariableDeclaration>(varDecl)
}

/**
 * Argument of a function call
 */
data class ValueArgument(
        val expr: ASTNode, // ExpressionNode
        val name: String?,
        val needUnpack: Boolean
): ASTNode() {
    override fun <R, D> accept(visitor: ASTNodeVisitor<R, D>, data: D) = visitor.visit(this, data)
    override val children = listOf(expr)
}

fun buildFunctionArguments(args: ParseTree) : List<FunctionArgument> = args.accept(FunctionArgumentBuilder())
fun buildValueArguments(args: ParseTree) : List<ValueArgument> = args.accept(ValueArgumentBuilder())