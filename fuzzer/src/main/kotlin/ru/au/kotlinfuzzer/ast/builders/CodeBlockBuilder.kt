package ru.au.kotlinfuzzer.ast.builders

import org.antlr.v4.runtime.ParserRuleContext
import ru.au.kotlinfuzzer.ast.BlockExpressionNode
import ru.au.kotlinfuzzer.ast.CodeBlockNode
import ru.au.kotlinfuzzer.ast.StatementsNode
import ru.au.kotlinfuzzer.generated.KotlinBaseVisitor
import ru.au.kotlinfuzzer.generated.KotlinParser

class CodeBlockBuilder : KotlinBaseVisitor<CodeBlockNode>() {
    override fun visitControlStructureBody(ctx: KotlinParser.ControlStructureBodyContext): CodeBlockNode
        = ctx.getChild(0).accept(this)

    override fun visitBlock(ctx: KotlinParser.BlockContext): CodeBlockNode
        = ctx.statements().accept(this)

    override fun visitBlockLevelExpression(ctx: KotlinParser.BlockLevelExpressionContext): CodeBlockNode
        = BlockExpressionNode(buildExpression(ctx.expression()))

    override fun visitStatements(ctx: KotlinParser.StatementsContext): CodeBlockNode
        = StatementsNode(buildAST(ctx).toMutableList())
}


fun buildCodeBlock(ctx: ParserRuleContext): CodeBlockNode
    = ctx.accept(CodeBlockBuilder())
