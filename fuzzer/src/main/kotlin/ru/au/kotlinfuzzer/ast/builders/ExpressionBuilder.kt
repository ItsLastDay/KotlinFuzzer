package ru.au.kotlinfuzzer.ast.builders

import ru.au.kotlinfuzzer.ast.*
import ru.au.kotlinfuzzer.ast.entities.NullableType
import ru.au.kotlinfuzzer.ast.entities.buildValueArguments
import ru.au.kotlinfuzzer.generated.KotlinBaseVisitor
import ru.au.kotlinfuzzer.generated.KotlinParser
import java.util.Collections.singletonList


class ExpressionBuilder : KotlinBaseVisitor<ExpressionNode>() {
    override fun visitKotlinFile(ctx: KotlinParser.KotlinFileContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitPreamble(ctx: KotlinParser.PreambleContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitImport_(ctx: KotlinParser.Import_Context): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitPackageHeader(ctx: KotlinParser.PackageHeaderContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitSimpleName_dot(ctx: KotlinParser.SimpleName_dotContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitModifiers(ctx: KotlinParser.ModifiersContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitSingleModifier(ctx: KotlinParser.SingleModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeModifiers(ctx: KotlinParser.TypeModifiersContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitSingleTypeModifier(ctx: KotlinParser.SingleTypeModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeAlias(ctx: KotlinParser.TypeAliasContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitModifier(ctx: KotlinParser.ModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitClassModifier(ctx: KotlinParser.ClassModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitMemberModifier(ctx: KotlinParser.MemberModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitAccessModifier(ctx: KotlinParser.AccessModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitVarianceAnnotation(ctx: KotlinParser.VarianceAnnotationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitParameterModifier(ctx: KotlinParser.ParameterModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeParameterModifier(ctx: KotlinParser.TypeParameterModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFunctionModifier(ctx: KotlinParser.FunctionModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitPropertyModifier(ctx: KotlinParser.PropertyModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitSuspendModifier(ctx: KotlinParser.SuspendModifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTopLevelObject(ctx: KotlinParser.TopLevelObjectContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitClass_(ctx: KotlinParser.Class_Context): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitPrimaryConstructor(ctx: KotlinParser.PrimaryConstructorContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFunctionParameter_comma(ctx: KotlinParser.FunctionParameter_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitClassBody(ctx: KotlinParser.ClassBodyContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitMembers(ctx: KotlinParser.MembersContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitDelegationSpecifier(ctx: KotlinParser.DelegationSpecifierContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitExplicitDelegation(ctx: KotlinParser.ExplicitDelegationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeParameters(ctx: KotlinParser.TypeParametersContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeParameter_comma(ctx: KotlinParser.TypeParameter_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeParameter(ctx: KotlinParser.TypeParameterContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeConstraints(ctx: KotlinParser.TypeConstraintsContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeConstraint_comma(ctx: KotlinParser.TypeConstraint_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeConstraint(ctx: KotlinParser.TypeConstraintContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitDelegationSpecifier_comma(ctx: KotlinParser.DelegationSpecifier_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitMemberDeclaration(ctx: KotlinParser.MemberDeclarationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitMemberDeclaration_inner(ctx: KotlinParser.MemberDeclaration_innerContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitAnonymousInitializer(ctx: KotlinParser.AnonymousInitializerContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitCompanionObject(ctx: KotlinParser.CompanionObjectContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitValueParameters(ctx: KotlinParser.ValueParametersContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFunctionParameter(ctx: KotlinParser.FunctionParameterContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitBlock(ctx: KotlinParser.BlockContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFunction(ctx: KotlinParser.FunctionContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFunctionBody(ctx: KotlinParser.FunctionBodyContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitVariableDeclarationEntry(ctx: KotlinParser.VariableDeclarationEntryContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitMultipleVariableDeclarations(ctx: KotlinParser.MultipleVariableDeclarationsContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitVariableDeclarationEntry_comma(ctx: KotlinParser.VariableDeclarationEntry_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitProperty(ctx: KotlinParser.PropertyContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitGetter(ctx: KotlinParser.GetterContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitSetter(ctx: KotlinParser.SetterContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitParameter(ctx: KotlinParser.ParameterContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFunctiontype_parameter(ctx: KotlinParser.Functiontype_parameterContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitObject(ctx: KotlinParser.ObjectContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitSecondaryConstructor(ctx: KotlinParser.SecondaryConstructorContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitConstructorDelegationCall(ctx: KotlinParser.ConstructorDelegationCallContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitEnumClassBody(ctx: KotlinParser.EnumClassBodyContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitEnumEntries(ctx: KotlinParser.EnumEntriesContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitEnumEntry_comma(ctx: KotlinParser.EnumEntry_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitEnumEntry(ctx: KotlinParser.EnumEntryContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitType(ctx: KotlinParser.TypeContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeReference(ctx: KotlinParser.TypeReferenceContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeReferenceNonNullable(ctx: KotlinParser.TypeReferenceNonNullableContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitNullableType(ctx: KotlinParser.NullableTypeContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFuncReceiverType(ctx: KotlinParser.FuncReceiverTypeContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitUserType(ctx: KotlinParser.UserTypeContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitSimpleUserType_dot(ctx: KotlinParser.SimpleUserType_dotContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitSimpleUserType(ctx: KotlinParser.SimpleUserTypeContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitOptProjection_usertype(ctx: KotlinParser.OptProjection_usertypeContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitOptProjection_elem(ctx: KotlinParser.OptProjection_elemContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitOptionalProjection(ctx: KotlinParser.OptionalProjectionContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFunctionType(ctx: KotlinParser.FunctionTypeContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitControlStructureBody(ctx: KotlinParser.ControlStructureBodyContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitCatchBlock(ctx: KotlinParser.CatchBlockContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFinallyBlock(ctx: KotlinParser.FinallyBlockContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitExpInfixCall(ctx: KotlinParser.ExpInfixCallContext): ExpressionNode {
        return InfixCallNode(ctx.simpleName().text,
                ctx.expression(0).accept(this),
                ctx.expression(1).accept(this))
    }

    override fun visitExpTypeOp(ctx: KotlinParser.ExpTypeOpContext): ExpressionNode {
        return AsIsOperation(ctx.expression().accept(this),
                buildType(ctx.type()),
                when (ctx.typeOperation()?.text) {
                    "as" -> AsIsType.AS
                    "as?" -> AsIsType.AS_QUEST
                    ":" -> AsIsType.COLON
                    else -> when (ctx.isOperation.text) {
                        "is" -> AsIsType.IS
                        "!is" -> AsIsType.NOT_IS
                        else -> throw AssertionError("Unknown in/is operation")
                    }


                })
    }

    override fun visitExpInIs(ctx: KotlinParser.ExpInIsContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                when (ctx.inOperation().text) {
                    "in" -> BinaryOpType.IN
                    "!in" -> BinaryOpType.NOT_IN
                    else -> throw AssertionError("Unknown 'in' operation")
                })
    }

    override fun visitExpComparison(ctx: KotlinParser.ExpComparisonContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                when (ctx.comparisonOperation().text) {
                    "<" -> BinaryOpType.LT
                    ">" -> BinaryOpType.GT
                    ">=" -> BinaryOpType.GE
                    "<=" -> BinaryOpType.LE
                    else -> throw AssertionError("Unknown comparison operation")
                })
    }

    override fun visitExpAssignment(ctx: KotlinParser.ExpAssignmentContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                when (ctx.assignmentOperator().text) {
                    "=" -> BinaryOpType.ASSIGN
                    "+=" -> BinaryOpType.ADD_ASSIGN
                    "-=" -> BinaryOpType.SUB_ASSIGN
                    "*=" -> BinaryOpType.MULTIPLY_ASSIGN
                    "/=" -> BinaryOpType.DIVIDE_ASSIGN
                    "%=" -> BinaryOpType.MODULO_ASSIGN
                    else -> throw AssertionError("Unknown assignment operation")
                })
    }

    override fun visitExpConjunction(ctx: KotlinParser.ExpConjunctionContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                BinaryOpType.AND)
    }

    override fun visitExpEquality(ctx: KotlinParser.ExpEqualityContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                when (ctx.equalityOperation().text) {
                    "!=" -> BinaryOpType.NOT_EQ
                    "==" -> BinaryOpType.EQ
                    "!==" -> BinaryOpType.NOT_REF_EQ
                    "===" -> BinaryOpType.REF_EQ
                    else -> throw AssertionError("Unknown equality operation")
                })
    }

    override fun visitExpDisjunction(ctx: KotlinParser.ExpDisjunctionContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                BinaryOpType.OR)
    }

    override fun visitExpRange(ctx: KotlinParser.ExpRangeContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                BinaryOpType.RANGE)
    }

    override fun visitExpMultiplicative(ctx: KotlinParser.ExpMultiplicativeContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                when (ctx.multiplicativeOperation().text) {
                    "*" -> BinaryOpType.MULTIPLY
                    "/" -> BinaryOpType.DIVIDE
                    "%" -> BinaryOpType.MODULO
                    else -> throw AssertionError("Unknown multiplicative operation")
                })
    }

    override fun visitExpPrefixUnary(ctx: KotlinParser.ExpPrefixUnaryContext): ExpressionNode {
        val expr = ctx.expression().accept(this)
        return when (ctx.prefixUnaryOperation().text) {
            "-" -> PrefixUnaryOpNode(expr, PrefixUnaryOpType.NEG, null, null)
            "+" -> PrefixUnaryOpNode(expr, PrefixUnaryOpType.POS, null, null)
            "++" -> PrefixUnaryOpNode(expr, PrefixUnaryOpType.INCREMENT, null, null)
            "--" -> PrefixUnaryOpNode(expr, PrefixUnaryOpType.DECREMENT, null, null)
            "!" -> PrefixUnaryOpNode(expr, PrefixUnaryOpType.NOT, null, null)
            else -> when {
                ctx.prefixUnaryOperation().labelDefinition() != null -> PrefixUnaryOpNode(expr, PrefixUnaryOpType.LABEL, null, ctx.prefixUnaryOperation().labelDefinition().labelName().text)
                else -> PrefixUnaryOpNode(expr, PrefixUnaryOpType.ANNOTATION,
                        buildAST(ctx.prefixUnaryOperation().annotation() ?: ctx.prefixUnaryOperation().annotationList()).single()
                        , null)
            }
        }
    }

    override fun visitExpElvis(ctx: KotlinParser.ExpElvisContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                BinaryOpType.ELVIS)
    }

    override fun visitExpAdditive(ctx: KotlinParser.ExpAdditiveContext): ExpressionNode {
        return BinaryOpNode(ctx.expression(0).accept(this),
                ctx.expression(1).accept(this),
                when (ctx.additiveOperation().text) {
                    "+" -> BinaryOpType.ADD
                    "-" -> BinaryOpType.SUB
                    else -> throw AssertionError("Unknown additive operation")
                })
    }

    override fun visitPostfixUnaryExpression(ctx: KotlinParser.PostfixUnaryExpressionContext): ExpressionNode {
        val opsList = ctx.postfixUnaryOperation()
        return makePostfixExpression(
                (ctx.callableReference() ?: ctx.atomicExpression()).accept(this)
                , opsList)
    }

    private fun makePostfixExpression(expressionNode: ExpressionNode, opsList: List<KotlinParser.PostfixUnaryOperationContext>): ExpressionNode {
        var resultingExpr = expressionNode
        for (op in opsList) {
            resultingExpr = when {
                op.callSuffix() != null -> {
                    val typeArgs = (op.callSuffix().callSuffixNoLambda()?.typeArguments()
                            ?: op.callSuffix().typeArguments())
                            ?.type_comma()?.type()?.map { buildType(it) } ?: emptyList()
                    val arguments = op.callSuffix().annotatedLambda()?.let {
                        singletonList(it.functionLiteral().accept(this))
                    } ?: buildValueArguments(op.callSuffix().callSuffixNoLambda().valueArguments())
                    FunctionCallNode(resultingExpr,
                            typeArgs,
                            arguments)
                }
                op.arrayAccess() != null -> ArrayAccessNode(resultingExpr,
                        op.arrayAccess().expression_comma().expression().map { it.accept(this) })
                op.memberAccessOperation() != null -> MemberAccessNode(resultingExpr,
                        (op.postfixUnaryExpression() ?: op.atomicExpression()).accept(this),
                        when (op.memberAccessOperation().text) {
                            "." -> MemberAccessType.DOT
                            "?." -> MemberAccessType.SAFE
                            else -> throw AssertionError("Unknown member access operation")
                        })
                else -> when (op.text) {
                    "++" -> PostfixUnaryNode(resultingExpr, PostfixUnaryOpType.INCREMENT)
                    "--" -> PostfixUnaryNode(resultingExpr, PostfixUnaryOpType.DECREMENT)
                    "!!" -> PostfixUnaryNode(resultingExpr, PostfixUnaryOpType.NOT_NULL)
                    else -> throw AssertionError("Unknown postfix operation")
                }
            }
        }

        return resultingExpr
    }

    override fun visitCallableReference(ctx: KotlinParser.CallableReferenceContext): ExpressionNode {
        return CallableReferenceNode(ctx.simpleName().text,
                ctx.userType()?.let {
                    val type = buildType(it)
                    if (ctx.nullable != null)
                        NullableType(type)
                    else
                        type
                })
    }

    override fun visitLabelReference(ctx: KotlinParser.LabelReferenceContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitLabelDefinition(ctx: KotlinParser.LabelDefinitionContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitStringTemplate(ctx: KotlinParser.StringTemplateContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitLongTemplate(ctx: KotlinParser.LongTemplateContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitDeclaration(ctx: KotlinParser.DeclarationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitStatement(ctx: KotlinParser.StatementContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitBlockLevelExpression(ctx: KotlinParser.BlockLevelExpressionContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitMultiplicativeOperation(ctx: KotlinParser.MultiplicativeOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitAdditiveOperation(ctx: KotlinParser.AdditiveOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitInOperation(ctx: KotlinParser.InOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeOperation(ctx: KotlinParser.TypeOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitIsOperation(ctx: KotlinParser.IsOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitComparisonOperation(ctx: KotlinParser.ComparisonOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitEqualityOperation(ctx: KotlinParser.EqualityOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitAssignmentOperator(ctx: KotlinParser.AssignmentOperatorContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitPrefixUnaryOperation(ctx: KotlinParser.PrefixUnaryOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitPostfixUnaryOperation(ctx: KotlinParser.PostfixUnaryOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitCallSuffix(ctx: KotlinParser.CallSuffixContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitAnnotatedLambda(ctx: KotlinParser.AnnotatedLambdaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitMemberAccessOperation(ctx: KotlinParser.MemberAccessOperationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitTypeArguments(ctx: KotlinParser.TypeArgumentsContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitValueArguments(ctx: KotlinParser.ValueArgumentsContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitLambdaParameter_comma(ctx: KotlinParser.LambdaParameter_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitLambdaParameter(ctx: KotlinParser.LambdaParameterContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitStatements(ctx: KotlinParser.StatementsContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitStatement_semi(ctx: KotlinParser.Statement_semiContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitConstructorInvocation(ctx: KotlinParser.ConstructorInvocationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitArrayAccess(ctx: KotlinParser.ArrayAccessContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitParameter_comma(ctx: KotlinParser.Parameter_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitFunctiontype_parameter_comma(ctx: KotlinParser.Functiontype_parameter_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitType_comma(ctx: KotlinParser.Type_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitExpression_comma(ctx: KotlinParser.Expression_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitWhenEntry(ctx: KotlinParser.WhenEntryContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitWhenCondition_comma(ctx: KotlinParser.WhenCondition_commaContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitWhenCondition(ctx: KotlinParser.WhenConditionContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitAnnotations(ctx: KotlinParser.AnnotationsContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitAnnotation(ctx: KotlinParser.AnnotationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitAnnotationList(ctx: KotlinParser.AnnotationListContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitAnnotationUseSiteTarget(ctx: KotlinParser.AnnotationUseSiteTargetContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitUnescapedAnnotation(ctx: KotlinParser.UnescapedAnnotationContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitSimpleName(ctx: KotlinParser.SimpleNameContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitShortTemplateEntryStart(ctx: KotlinParser.ShortTemplateEntryStartContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitLabelName(ctx: KotlinParser.LabelNameContext): ExpressionNode {
        return NotImplementedExpressionNode(getTextFromCtx(ctx))
    }

    override fun visitLiteralConstant(ctx: KotlinParser.LiteralConstantContext): ExpressionNode
        = LiteralConstantNode(ctx.text)

    override fun visitExpAtomic(ctx: KotlinParser.ExpAtomicContext): ExpressionNode
            = ctx.atomicExpression().accept(this)
    override fun visitExpPostfixUnary(ctx: KotlinParser.ExpPostfixUnaryContext): ExpressionNode
            = ctx.postfixUnaryExpression().accept(this)

    override fun visitAtomExpSingleChild(ctx: KotlinParser.AtomExpSingleChildContext): ExpressionNode
                = ctx.getChild(0).accept(this)
    override fun visitAtomExpNested(ctx: KotlinParser.AtomExpNestedContext): ExpressionNode
                = ParenthizedExpressionNode(ctx.expression().accept(this))

    override fun visitAtomExpVariableUse(ctx: KotlinParser.AtomExpVariableUseContext): ExpressionNode
            = VariableUsageNode(ctx.simpleName().text)

    override fun visitAtomExpSuper(ctx: KotlinParser.AtomExpSuperContext): ExpressionNode
            = SuperNode(ctx.type()?.let { buildType(it) }, ctx.labelReference()?.labelName()?.text)

    override fun visitAtomExpThis(ctx: KotlinParser.AtomExpThisContext): ExpressionNode
        = ThisNode(ctx.labelReference()?.labelName()?.text)

    override fun visitIf_(ctx: KotlinParser.If_Context): ExpressionNode {
        val ifExpr = ctx.expression().accept(this)
        val thenBlock = ctx.thenBlock?.let { buildCodeBlock(it) }
        val elseBlock = ctx.elseBlock?.let { buildCodeBlock(it) }
        return IfNode(ifExpr, thenBlock, elseBlock)
    }

    override fun visitTry_(ctx: KotlinParser.Try_Context): ExpressionNode {
        val codeBlock = buildCodeBlock(ctx.block())
        val catchBlocks = ctx.catchBlock().map { buildAST(it).single() as CatchBlock }
        val finallyBlock = ctx.finallyBlock()?.let { buildCodeBlock(it) }
        return TryNode(codeBlock, catchBlocks, finallyBlock)
    }

    override fun visitWhen(ctx: KotlinParser.WhenContext): ExpressionNode {
        val expr = ctx.expression()?.accept(this)
        val entries = ctx.whenEntry().map { buildAST(it).single() as WhenEntry }
        return WhenNode(expr, entries)
    }

    override fun visitJump(ctx: KotlinParser.JumpContext): ExpressionNode {
        val expr = ctx.expression()?.accept(this)
        val labelName = ctx.labelReference()?.labelName()?.text
        return when {
            ctx.KW_THROW() != null -> ThrowNode(expr!!)
            ctx.KW_RETURN() != null -> ReturnNode(labelName, expr)
            ctx.KW_CONTINUE() != null -> LoopJumpNode(LoopJumpNodeType.CONTINUE, labelName)
            ctx.KW_BREAK() != null -> LoopJumpNode(LoopJumpNodeType.BREAK, labelName)
            else -> throw IllegalStateException()
        }
    }

    override fun visitLoop(ctx: KotlinParser.LoopContext): ExpressionNode
            = ctx.getChild(0).accept(this)

    override fun visitFor_(ctx: KotlinParser.For_Context): ExpressionNode {
        val declarations = buildVarDeclarations(ctx.multipleVariableDeclarations() ?: ctx.variableDeclarationEntry())
        val expr = ctx.expression().accept(this)
        val body = buildCodeBlock(ctx.controlStructureBody())
        return ForLoopNode(declarations, expr, body)
    }

    override fun visitWhile_(ctx: KotlinParser.While_Context): ExpressionNode {
        val expr = ctx.expression().accept(this)
        val body = ctx.controlStructureBody()?.let { buildCodeBlock(it) }
        return WhileLoopNode(WhileLoopType.WHILE, expr, body)
    }

    override fun visitDoWhile(ctx: KotlinParser.DoWhileContext): ExpressionNode {
        val expr = ctx.expression().accept(this)
        val body = buildCodeBlock(ctx.controlStructureBody())
        return WhileLoopNode(WhileLoopType.DO_WHILE, expr, body)
    }

    override fun visitObjectLiteral(ctx: KotlinParser.ObjectLiteralContext): ExpressionNode
        = ObjectLiteralNode(ctx.classBody()?.let { buildAST(it).single() },
            ctx.delegationSpecifier_comma()?.let { buildAST(it).single() })

    override fun visitFunctionLiteral(ctx: KotlinParser.FunctionLiteralContext): ExpressionNode {
        val declarations = ctx.lambdaParameter_comma()?.let { buildVarDeclarations(it) } ?: emptyList()
        val statements = buildCodeBlock(ctx.statements())
        return FunctionLiteralNode(statements, declarations)
    }

}

fun buildExpression(ctx: KotlinParser.ExpressionContext): ExpressionNode
    = ctx.accept(ExpressionBuilder())