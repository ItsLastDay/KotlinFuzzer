package ru.au.kotlinfuzzer.ast.builders

import org.antlr.v4.runtime.ParserRuleContext

/**
 * Get full text (with all whitespaces, comments, etc) from context.
 */
fun getTextFromCtx(ctx: ParserRuleContext): String {
    val startIndex = ctx.start.startIndex
    val stopIndex = ctx.stop.stopIndex
    val inputStream = ctx.start.inputStream
    return inputStream.getText(org.antlr.v4.runtime.misc.Interval.of(startIndex, stopIndex))
}