package ru.au.kotlinfuzzer.ast.builders

import org.antlr.v4.runtime.ParserRuleContext
import ru.au.kotlinfuzzer.ast.*
import ru.au.kotlinfuzzer.ast.entities.SimpleType
import ru.au.kotlinfuzzer.ast.entities.TypeProjection
import ru.au.kotlinfuzzer.ast.entities.VariableDeclaration
import ru.au.kotlinfuzzer.ast.entities.buildFunctionArguments
import ru.au.kotlinfuzzer.ast.postprocess.computeParents
import ru.au.kotlinfuzzer.generated.KotlinBaseVisitor
import ru.au.kotlinfuzzer.generated.KotlinParser
import ru.au.kotlinfuzzer.parsing.getParseTreeFromFile
import ru.au.kotlinfuzzer.scope.computeScope
import java.io.File
import java.util.Collections.singletonList

class ASTBuilder : KotlinBaseVisitor<List<ASTNode>>() {
    // Useful function when text in `NotImplementedNode` interferes
    // with usual pattern in ASTWriter.
    // Example: "class A { smth }" is rewritten as "class A { rewrite body }",
    // which is then turned into "class A { { smth } }"
    private fun removeCurlyBraces(text: String): String {
        return text.trimStart({it == ' ' || it == '\n'})
                .removePrefix("{")
                .trimEnd({it == ' ' || it == '\n'})
                .removeSuffix("}")
    }

    override fun visitSimpleName_dot(ctx: KotlinParser.SimpleName_dotContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitModifiers(ctx: KotlinParser.ModifiersContext): List<ASTNode> {
        val texts = ctx.singleModifier().map { it.text }.filter { it.isNotBlank() }
        return singletonList(ModifiersNode(texts))
    }

    override fun visitSingleModifier(ctx: KotlinParser.SingleModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTypeModifiers(ctx: KotlinParser.TypeModifiersContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitSingleTypeModifier(ctx: KotlinParser.SingleTypeModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitModifier(ctx: KotlinParser.ModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitClassModifier(ctx: KotlinParser.ClassModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitMemberModifier(ctx: KotlinParser.MemberModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAccessModifier(ctx: KotlinParser.AccessModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitVarianceAnnotation(ctx: KotlinParser.VarianceAnnotationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitParameterModifier(ctx: KotlinParser.ParameterModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTypeParameterModifier(ctx: KotlinParser.TypeParameterModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFunctionModifier(ctx: KotlinParser.FunctionModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitPropertyModifier(ctx: KotlinParser.PropertyModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitSuspendModifier(ctx: KotlinParser.SuspendModifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitPrimaryConstructor(ctx: KotlinParser.PrimaryConstructorContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFunctionParameter_comma(ctx: KotlinParser.FunctionParameter_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitClassBody(ctx: KotlinParser.ClassBodyContext): List<ASTNode> {
        return ctx.members().accept(this)
    }

    override fun visitMembers(ctx: KotlinParser.MembersContext): List<ASTNode> {
        return singletonList(MembersNode(ctx.memberDeclaration().flatMap { it.accept(this) }))
    }

    override fun visitDelegationSpecifier(ctx: KotlinParser.DelegationSpecifierContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExplicitDelegation(ctx: KotlinParser.ExplicitDelegationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTypeParameters(ctx: KotlinParser.TypeParametersContext): List<ASTNode> {
        val insideTypes = ctx.typeParameter_comma().typeParameter().map {
            val baseType = SimpleType(it.simpleName().text)
            val modifiers = it.modifiers().accept(this).single() as ModifiersNode
            if (modifiers.rawModifiersAnnotations.isNotEmpty()
                    || it.userType() != null) {
                TypeProjection(modifiers, baseType,
                        it.userType()?.let { buildType(it) })
            } else
                baseType
        }

        return singletonList(GenericTypeParams(insideTypes))
    }

    override fun visitTypeParameter_comma(ctx: KotlinParser.TypeParameter_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTypeParameter(ctx: KotlinParser.TypeParameterContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTypeConstraints(ctx: KotlinParser.TypeConstraintsContext): List<ASTNode> {
        return singletonList(WhereConstraints(ctx.typeConstraint_comma()?.accept(this) ?: emptyList()))
    }

    override fun visitTypeConstraint_comma(ctx: KotlinParser.TypeConstraint_commaContext): List<ASTNode> {
        return ctx.typeConstraint().map { it.accept(this).single() }
    }

    override fun visitTypeConstraint(ctx: KotlinParser.TypeConstraintContext): List<ASTNode> {
        return singletonList(VariableDeclaration(ctx.simpleName().text, buildType(ctx.type())))
    }

    override fun visitDelegationSpecifier_comma(ctx: KotlinParser.DelegationSpecifier_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitMemberDeclaration(ctx: KotlinParser.MemberDeclarationContext): List<ASTNode> {
        return ctx.memberDeclaration_inner().accept(this)
    }

    override fun visitMemberDeclaration_inner(ctx: KotlinParser.MemberDeclaration_innerContext): List<ASTNode> {
        return ctx.children[0].accept(this)
    }

    override fun visitAnonymousInitializer(ctx: KotlinParser.AnonymousInitializerContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitCompanionObject(ctx: KotlinParser.CompanionObjectContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitValueParameters(ctx: KotlinParser.ValueParametersContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFunctionParameter(ctx: KotlinParser.FunctionParameterContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitBlock(ctx: KotlinParser.BlockContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitVariableDeclarationEntry(ctx: KotlinParser.VariableDeclarationEntryContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitMultipleVariableDeclarations(ctx: KotlinParser.MultipleVariableDeclarationsContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitVariableDeclarationEntry_comma(ctx: KotlinParser.VariableDeclarationEntry_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitGetter(ctx: KotlinParser.GetterContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitSetter(ctx: KotlinParser.SetterContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitParameter(ctx: KotlinParser.ParameterContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFunctiontype_parameter(ctx: KotlinParser.Functiontype_parameterContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitSecondaryConstructor(ctx: KotlinParser.SecondaryConstructorContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitConstructorDelegationCall(ctx: KotlinParser.ConstructorDelegationCallContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitEnumClassBody(ctx: KotlinParser.EnumClassBodyContext): List<ASTNode> {
        return singletonList(NotImplementedNode(removeCurlyBraces(getTextFromCtx(ctx))))
    }

    override fun visitEnumEntries(ctx: KotlinParser.EnumEntriesContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitEnumEntry_comma(ctx: KotlinParser.EnumEntry_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitEnumEntry(ctx: KotlinParser.EnumEntryContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitType(ctx: KotlinParser.TypeContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTypeReference(ctx: KotlinParser.TypeReferenceContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTypeReferenceNonNullable(ctx: KotlinParser.TypeReferenceNonNullableContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitNullableType(ctx: KotlinParser.NullableTypeContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFuncReceiverType(ctx: KotlinParser.FuncReceiverTypeContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitUserType(ctx: KotlinParser.UserTypeContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitSimpleUserType_dot(ctx: KotlinParser.SimpleUserType_dotContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitSimpleUserType(ctx: KotlinParser.SimpleUserTypeContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitOptProjection_usertype(ctx: KotlinParser.OptProjection_usertypeContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitOptProjection_elem(ctx: KotlinParser.OptProjection_elemContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitOptionalProjection(ctx: KotlinParser.OptionalProjectionContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFunctionType(ctx: KotlinParser.FunctionTypeContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitControlStructureBody(ctx: KotlinParser.ControlStructureBodyContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitIf_(ctx: KotlinParser.If_Context): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTry_(ctx: KotlinParser.Try_Context): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFinallyBlock(ctx: KotlinParser.FinallyBlockContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitLoop(ctx: KotlinParser.LoopContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFor_(ctx: KotlinParser.For_Context): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitWhile_(ctx: KotlinParser.While_Context): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitDoWhile(ctx: KotlinParser.DoWhileContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpAtomic(ctx: KotlinParser.ExpAtomicContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpInfixCall(ctx: KotlinParser.ExpInfixCallContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpPostfixUnary(ctx: KotlinParser.ExpPostfixUnaryContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpInIs(ctx: KotlinParser.ExpInIsContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpComparison(ctx: KotlinParser.ExpComparisonContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpAssignment(ctx: KotlinParser.ExpAssignmentContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpConjunction(ctx: KotlinParser.ExpConjunctionContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpEquality(ctx: KotlinParser.ExpEqualityContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpDisjunction(ctx: KotlinParser.ExpDisjunctionContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpRange(ctx: KotlinParser.ExpRangeContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpMultiplicative(ctx: KotlinParser.ExpMultiplicativeContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpPrefixUnary(ctx: KotlinParser.ExpPrefixUnaryContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpElvis(ctx: KotlinParser.ExpElvisContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpAdditive(ctx: KotlinParser.ExpAdditiveContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitPostfixUnaryExpression(ctx: KotlinParser.PostfixUnaryExpressionContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitCallableReference(ctx: KotlinParser.CallableReferenceContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAtomExpNested(ctx: KotlinParser.AtomExpNestedContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAtomExpSingleChild(ctx: KotlinParser.AtomExpSingleChildContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAtomExpThis(ctx: KotlinParser.AtomExpThisContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAtomExpSuper(ctx: KotlinParser.AtomExpSuperContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAtomExpVariableUse(ctx: KotlinParser.AtomExpVariableUseContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitLabelReference(ctx: KotlinParser.LabelReferenceContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitLabelDefinition(ctx: KotlinParser.LabelDefinitionContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitLiteralConstant(ctx: KotlinParser.LiteralConstantContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitStringTemplate(ctx: KotlinParser.StringTemplateContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitLongTemplate(ctx: KotlinParser.LongTemplateContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitMultiplicativeOperation(ctx: KotlinParser.MultiplicativeOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAdditiveOperation(ctx: KotlinParser.AdditiveOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitInOperation(ctx: KotlinParser.InOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTypeOperation(ctx: KotlinParser.TypeOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitIsOperation(ctx: KotlinParser.IsOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitComparisonOperation(ctx: KotlinParser.ComparisonOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitEqualityOperation(ctx: KotlinParser.EqualityOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAssignmentOperator(ctx: KotlinParser.AssignmentOperatorContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitPrefixUnaryOperation(ctx: KotlinParser.PrefixUnaryOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitPostfixUnaryOperation(ctx: KotlinParser.PostfixUnaryOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitCallSuffix(ctx: KotlinParser.CallSuffixContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAnnotatedLambda(ctx: KotlinParser.AnnotatedLambdaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitMemberAccessOperation(ctx: KotlinParser.MemberAccessOperationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitTypeArguments(ctx: KotlinParser.TypeArgumentsContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitValueArguments(ctx: KotlinParser.ValueArgumentsContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitJump(ctx: KotlinParser.JumpContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFunctionLiteral(ctx: KotlinParser.FunctionLiteralContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitLambdaParameter_comma(ctx: KotlinParser.LambdaParameter_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitLambdaParameter(ctx: KotlinParser.LambdaParameterContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitConstructorInvocation(ctx: KotlinParser.ConstructorInvocationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitArrayAccess(ctx: KotlinParser.ArrayAccessContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitObjectLiteral(ctx: KotlinParser.ObjectLiteralContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitParameter_comma(ctx: KotlinParser.Parameter_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitFunctiontype_parameter_comma(ctx: KotlinParser.Functiontype_parameter_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitType_comma(ctx: KotlinParser.Type_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitExpression_comma(ctx: KotlinParser.Expression_commaContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitWhen(ctx: KotlinParser.WhenContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAnnotations(ctx: KotlinParser.AnnotationsContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAnnotation(ctx: KotlinParser.AnnotationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAnnotationList(ctx: KotlinParser.AnnotationListContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitAnnotationUseSiteTarget(ctx: KotlinParser.AnnotationUseSiteTargetContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitUnescapedAnnotation(ctx: KotlinParser.UnescapedAnnotationContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitSimpleName(ctx: KotlinParser.SimpleNameContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitShortTemplateEntryStart(ctx: KotlinParser.ShortTemplateEntryStartContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitLabelName(ctx: KotlinParser.LabelNameContext): List<ASTNode> {
        return singletonList(NotImplementedNode(getTextFromCtx(ctx)))
    }

    override fun visitKotlinFile(ctx: KotlinParser.KotlinFileContext): List<ASTNode> {
        val preambleChildren = visitPreamble(ctx.preamble())
        val topLevelChildren = ctx.topLevelObject().flatMap { visitTopLevelObject(it) }

        return singletonList(KotlinFileNode(MembersNode(preambleChildren + topLevelChildren)))
    }

    override fun visitStatements(ctx: KotlinParser.StatementsContext): List<ASTNode> {
        return ctx.statement_semi()?.accept(this) ?: emptyList()
    }

    override fun visitStatement_semi(ctx: KotlinParser.Statement_semiContext): List<ASTNode> {
        return ctx.statement().flatMap { it.accept(this) }
    }

    override fun visitStatement(ctx: KotlinParser.StatementContext): List<ASTNode>
        = ctx.getChild(0).accept(this)

    override fun visitDeclaration(ctx: KotlinParser.DeclarationContext): List<ASTNode>
        = ctx.getChild(0).accept(this)

    override fun visitProperty(ctx: KotlinParser.PropertyContext): List<ASTNode> {
        val propType = if (ctx.KW_VAL() != null) PropertyType.VAL else PropertyType.VAR
        val propDelegationType = when {
            ctx.KW_BY() != null -> PropertyDelegationType.BY
            ctx.expression() != null -> PropertyDelegationType.EQ
            else -> PropertyDelegationType.NONE
        }
        val receiverType = ctx.type()?.let { buildType(it) }
        val genericParams = ctx.typeParameters()?.accept(this)?.single()
        val varDeclarations = buildVarDeclarations(ctx.multipleVariableDeclarations() ?: ctx.variableDeclarationEntry())
        val initExpr = ctx.expression()?.let { buildExpression(it) }
        val whereConstraints = ctx.typeConstraints().accept(this).single()
        val getter = ctx.getter()?.accept(this)?.single()
        val setter = ctx.setter()?.accept(this)?.single()
        val modifiers = ctx.modifiers().accept(this).single()
        return singletonList(PropertyDeclarationNode(modifiers, propType, propDelegationType, receiverType,
                varDeclarations, initExpr, whereConstraints, getter, setter,
                genericParams))
    }

    override fun visitTypeAlias(ctx: KotlinParser.TypeAliasContext): List<ASTNode>
        = singletonList(TypealiasNode(ctx.simpleName().text, buildType(ctx.type()),
            ctx.typeParameters()?.accept(this)?.single()))

    override fun visitObject(ctx: KotlinParser.ObjectContext): List<ASTNode>
        = singletonList(ObjectNode(ctx.simpleName().text, ctx.classBody()?.accept(this)?.single(),
            ctx.delegationSpecifier_comma()?.accept(this)?.single()))

    override fun visitBlockLevelExpression(ctx: KotlinParser.BlockLevelExpressionContext): List<ASTNode>
        = singletonList(buildCodeBlock(ctx))

    override fun visitClass_(ctx: KotlinParser.Class_Context): List<ASTNode> {
        val modifiers = ctx.modifiers().accept(this).single()
        val clsType = if (ctx.KW_CLASS() != null) ClassNodeType.CLASS else ClassNodeType.INTERFACE
        val name = ctx.simpleName().text
        val body = when {
            ctx.classBody() != null -> ctx.classBody().accept(this).single()
            ctx.enumClassBody() != null -> ctx.enumClassBody().accept(this).single()
            else -> null
        }
        val constructor = ctx.primaryConstructor()?.accept(this)?.single()
        val delegationSpecifiers = ctx.delegationSpecifier_comma()?.accept(this)?.single()
        val typeParams = ctx.typeParameters()?.accept(this)?.single()
        val whereConstraints = ctx.typeConstraints().accept(this).single()
        return singletonList(ClassDeclarationNode(modifiers, name, clsType, constructor,
                body, delegationSpecifiers, typeParams, whereConstraints))
    }

    override fun visitPreamble(ctx: KotlinParser.PreambleContext): List<ASTNode> {
        val preambleList = ctx.packageHeader()?.let { visitPackageHeader(it) } ?: emptyList()
        val importList = ctx.import_().flatMap { visitImport_(it) }
        return preambleList + importList
    }

    override fun visitPackageHeader(ctx: KotlinParser.PackageHeaderContext): List<ASTNode> {
        return singletonList(PackageNode(ctx.simpleName_dot().text))
    }

    override fun visitImport_(ctx: KotlinParser.Import_Context): List<ASTNode> {
        val node = ImportNode(ctx.simpleName_dot().text, ctx.simpleName()?.text, ctx.isImportAll != null)
        return singletonList(node)
    }

    override fun visitTopLevelObject(ctx: KotlinParser.TopLevelObjectContext): List<ASTNode> {
        return ctx.getChild(0).accept(this)
    }

    override fun visitFunction(ctx: KotlinParser.FunctionContext): List<ASTNode> {
        val modifiers = ctx.modifiers().accept(this).single()
        val genericParams = ctx.genericParams?.accept(this)?.single()
        val receiverType = ctx.receiverType?.let { buildType(it) }
        val funName = ctx.simpleName().text

        val body = ctx.functionBody()?.accept(this)?.single()
        // Return type is inferred by kotlinc when function body is "= smth".
        val returnType = ctx.returnType?.let { buildType(it) } ?: if (body !is ExpressionNode) unitType else null
        val args = buildFunctionArguments(ctx.valueParameters())
        val whereConstrains = ctx.typeConstraints().accept(this).single()

        val node = FunctionDeclarationNode(modifiers, genericParams, funName, receiverType,
                returnType, args, body, whereConstrains)
        return singletonList(node)
    }

    override fun visitFunctionBody(ctx: KotlinParser.FunctionBodyContext): List<ASTNode> {
        return singletonList(if (ctx.block() != null) buildCodeBlock(ctx.block()) else buildExpression(ctx.expression()))
    }

    override fun visitCatchBlock(ctx: KotlinParser.CatchBlockContext): List<ASTNode> {
        val varName = ctx.simpleName().text
        val varType = buildType(ctx.userType())
        val codeBlock = buildCodeBlock(ctx.block())
        return singletonList(CatchBlock(codeBlock, varName, varType))
    }

    override fun visitWhenEntry(ctx: KotlinParser.WhenEntryContext): List<ASTNode> {
        val code = buildCodeBlock(ctx.controlStructureBody())
        val conditions = (if (ctx.KW_ELSE() != null) singletonList(WhenConditionElse())
            else ctx.whenCondition_comma().accept(this).map { it as WhenCondition })
        return singletonList(WhenEntry(conditions, code))
    }

    override fun visitWhenCondition_comma(ctx: KotlinParser.WhenCondition_commaContext): List<ASTNode>
        = ctx.whenCondition().flatMap { it.accept(this) }

    override fun visitWhenCondition(ctx: KotlinParser.WhenConditionContext): List<ASTNode> {
        val expr = ctx.expression()?.let { buildExpression(it) }
        val type = ctx.type()?.let { buildType(it) }
        return singletonList(when {
            ctx.KW_IN() != null -> WhenConditionIn(expr!!, false)
            ctx.KW_NOT_IN() != null -> WhenConditionIn(expr!!, true)
            ctx.KW_IS() != null -> WhenConditionIs(type!!, false)
            ctx.KW_NOT_IS() != null -> WhenConditionIs(type!!, true)
            else -> WhenConditionExpr(expr!!)
        })
    }

}

fun buildASTFromFile(filename: String): KotlinFileNode {
    val tree = getParseTreeFromFile(filename)
    val ast = ASTBuilder().visit(tree).single()

    computeParents(ast)
    computeScope(ast)

    return ast as KotlinFileNode
}

fun buildAST(ctx: ParserRuleContext): List<ASTNode> = ctx.accept(ASTBuilder())

fun buildASTFromFile(file: File) = buildASTFromFile(file.absolutePath)