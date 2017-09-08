package ru.au.kotlinfuzzer.ast.builders

import org.antlr.v4.runtime.ParserRuleContext
import ru.au.kotlinfuzzer.ast.entities.FunctionArgument
import ru.au.kotlinfuzzer.ast.entities.ValueArgument
import ru.au.kotlinfuzzer.ast.entities.VariableDeclaration
import ru.au.kotlinfuzzer.generated.KotlinBaseVisitor
import ru.au.kotlinfuzzer.generated.KotlinParser
import java.util.Collections.singletonList

class VariableDeclarationBuilder : KotlinBaseVisitor<List<VariableDeclaration>>() {
    override fun visitVariableDeclarationEntry(ctx: KotlinParser.VariableDeclarationEntryContext): List<VariableDeclaration>
        = singletonList(VariableDeclaration(ctx.simpleName().text, ctx.type()?.let { buildType(it) }))

    override fun visitMultipleVariableDeclarations(ctx: KotlinParser.MultipleVariableDeclarationsContext): List<VariableDeclaration>
        = ctx.variableDeclarationEntry_comma().accept(this)

    override fun visitVariableDeclarationEntry_comma(ctx: KotlinParser.VariableDeclarationEntry_commaContext): List<VariableDeclaration>
        = ctx.variableDeclarationEntry().flatMap { it.accept(this) }

    override fun visitLambdaParameter_comma(ctx: KotlinParser.LambdaParameter_commaContext): List<VariableDeclaration>
        = ctx.lambdaParameter().flatMap { it.accept(this) }

    override fun visitLambdaParameter(ctx: KotlinParser.LambdaParameterContext): List<VariableDeclaration> {
        ctx.variableDeclarationEntry()?.let { return it.accept(this) }
        var declarations = ctx.multipleVariableDeclarations().accept(this)
        if (ctx.type() != null) {
            val type = buildType(ctx.type())
            declarations = declarations.map {
                VariableDeclaration(it.name, type)
            }
        }

        return declarations
    }
}

class ValueArgumentBuilder : KotlinBaseVisitor<List<ValueArgument>>() {
    override fun visitValueArguments(ctx: KotlinParser.ValueArgumentsContext): List<ValueArgument> {
        return ctx.valueArgumentElement().flatMap { it.accept(this) }
    }

    override fun visitValueArgumentElement(ctx: KotlinParser.ValueArgumentElementContext): List<ValueArgument> {
        return singletonList(ValueArgument(buildExpression(ctx.expression()),
                ctx.simpleName()?.text, ctx.unpack != null))
    }
}

class FunctionArgumentBuilder : KotlinBaseVisitor<List<FunctionArgument>>() {
    override fun visitValueParameters(ctx: KotlinParser.ValueParametersContext): List<FunctionArgument> {
        return ctx.functionParameter_comma()?.let { visitFunctionParameter_comma(it) } ?: emptyList()
    }

    override fun visitFunctionParameter_comma(ctx: KotlinParser.FunctionParameter_commaContext): List<FunctionArgument> {
        return ctx.functionParameter().flatMap { visitFunctionParameter(it) }
    }

    override fun visitFunctionParameter(ctx: KotlinParser.FunctionParameterContext): List<FunctionArgument> {
        val paramWithoutDefaultVal = visitParameter(ctx.parameter())
        ctx.expression()?.let { return singletonList(
                FunctionArgument(paramWithoutDefaultVal[0].varDecl, buildExpression(it))) }
        return paramWithoutDefaultVal
    }

    override fun visitParameter(ctx: KotlinParser.ParameterContext): List<FunctionArgument> {
        val name = ctx.simpleName().text
        val type = buildType(ctx.type())
        return singletonList(FunctionArgument(VariableDeclaration(name, type), null))
    }
}

fun buildVarDeclarations(ctx: ParserRuleContext): List<VariableDeclaration>
        = ctx.accept(VariableDeclarationBuilder())

