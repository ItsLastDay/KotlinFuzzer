package ru.au.kotlinfuzzer.generators

import ru.au.kotlinfuzzer.ast.*
import java.util.*

private val random = Random(System.getenv("fixedMutationSeed")?.toLong() ?: System.currentTimeMillis())

fun <T> List<T>.randomChoice(): T {
    return get(random.nextInt(size))
}

private val booleanOps = listOf(
        BinaryOpType.IN, BinaryOpType.NOT_IN,
        BinaryOpType.LT, BinaryOpType.GT, BinaryOpType.LE, BinaryOpType.GE,
        BinaryOpType.EQ, BinaryOpType.NOT_EQ
)

private val standardExprs = listOf(
        LiteralConstantNode("null"),
        LiteralConstantNode("1"),
        LiteralConstantNode("\"abc\""),
        LiteralConstantNode("true"),
        LiteralConstantNode("false"),
        LiteralConstantNode("it"),
        ThisNode(null),
        SuperNode(null, null)
)

fun generateRandomExpression(): ExpressionNode {
    return standardExprs.randomChoice()
}

fun generateExpressionTypedAs(expr: ExpressionNode): ExpressionNode {
    return expr
}

fun generateExpressionTypedAsOrRandom(expr: ExpressionNode): ExpressionNode {
    if (random.nextFloat() < 0.20)
        return generateExpressionTypedAs(expr)
    return generateRandomExpression()
}

fun generateRandomBooleanExpr(seedExpr: ExpressionNode): ExpressionNode {
    val rhs = if (random.nextFloat() < 0.70) seedExpr else generateRandomExpression()
    return BinaryOpNode(seedExpr, rhs, booleanOps.randomChoice())
}