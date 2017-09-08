// Generated from /home/last/AU/KotlinFuzzer/repo/src/parser/Kotlin.g4 by ANTLR 4.7
package ru.au.kotlinfuzzer.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KotlinParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KotlinVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KotlinParser#kotlinFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKotlinFile(KotlinParser.KotlinFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#preamble}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreamble(KotlinParser.PreambleContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#import_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_(KotlinParser.Import_Context ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#packageHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageHeader(KotlinParser.PackageHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#simpleName_dot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleName_dot(KotlinParser.SimpleName_dotContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#modifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiers(KotlinParser.ModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#singleModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleModifier(KotlinParser.SingleModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeModifiers(KotlinParser.TypeModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#singleTypeModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeModifier(KotlinParser.SingleTypeModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAlias(KotlinParser.TypeAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(KotlinParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(KotlinParser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#memberModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberModifier(KotlinParser.MemberModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#accessModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessModifier(KotlinParser.AccessModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#varianceAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarianceAnnotation(KotlinParser.VarianceAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#parameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterModifier(KotlinParser.ParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(KotlinParser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functionModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionModifier(KotlinParser.FunctionModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#propertyModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyModifier(KotlinParser.PropertyModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#suspendModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuspendModifier(KotlinParser.SuspendModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#topLevelObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelObject(KotlinParser.TopLevelObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#class_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_(KotlinParser.Class_Context ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#primaryConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryConstructor(KotlinParser.PrimaryConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functionParameter_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameter_comma(KotlinParser.FunctionParameter_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(KotlinParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#members}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMembers(KotlinParser.MembersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#delegationSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelegationSpecifier(KotlinParser.DelegationSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#explicitDelegation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitDelegation(KotlinParser.ExplicitDelegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(KotlinParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeParameter_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter_comma(KotlinParser.TypeParameter_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(KotlinParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeConstraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstraints(KotlinParser.TypeConstraintsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeConstraint_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstraint_comma(KotlinParser.TypeConstraint_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstraint(KotlinParser.TypeConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#delegationSpecifier_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelegationSpecifier_comma(KotlinParser.DelegationSpecifier_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration(KotlinParser.MemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#memberDeclaration_inner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration_inner(KotlinParser.MemberDeclaration_innerContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#anonymousInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousInitializer(KotlinParser.AnonymousInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#companionObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompanionObject(KotlinParser.CompanionObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#valueParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueParameters(KotlinParser.ValueParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functionParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameter(KotlinParser.FunctionParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(KotlinParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(KotlinParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(KotlinParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#variableDeclarationEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationEntry(KotlinParser.VariableDeclarationEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#multipleVariableDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleVariableDeclarations(KotlinParser.MultipleVariableDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#variableDeclarationEntry_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationEntry_comma(KotlinParser.VariableDeclarationEntry_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(KotlinParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#getter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetter(KotlinParser.GetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#setter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetter(KotlinParser.SetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(KotlinParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functiontype_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiontype_parameter(KotlinParser.Functiontype_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(KotlinParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#secondaryConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondaryConstructor(KotlinParser.SecondaryConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#constructorDelegationCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDelegationCall(KotlinParser.ConstructorDelegationCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#enumClassBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumClassBody(KotlinParser.EnumClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#enumEntries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumEntries(KotlinParser.EnumEntriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#enumEntry_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumEntry_comma(KotlinParser.EnumEntry_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#enumEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumEntry(KotlinParser.EnumEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(KotlinParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeReference(KotlinParser.TypeReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeReferenceNonNullable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeReferenceNonNullable(KotlinParser.TypeReferenceNonNullableContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#nullableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullableType(KotlinParser.NullableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#funcReceiverType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncReceiverType(KotlinParser.FuncReceiverTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#userType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserType(KotlinParser.UserTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#simpleUserType_dot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleUserType_dot(KotlinParser.SimpleUserType_dotContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#simpleUserType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleUserType(KotlinParser.SimpleUserTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#optProjection_usertype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptProjection_usertype(KotlinParser.OptProjection_usertypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#optProjection_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptProjection_elem(KotlinParser.OptProjection_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#optionalProjection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalProjection(KotlinParser.OptionalProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(KotlinParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#controlStructureBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStructureBody(KotlinParser.ControlStructureBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#if_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_(KotlinParser.If_Context ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#try_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_(KotlinParser.Try_Context ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#catchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchBlock(KotlinParser.CatchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(KotlinParser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(KotlinParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#for_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_(KotlinParser.For_Context ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#while_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_(KotlinParser.While_Context ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#doWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(KotlinParser.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expAtomic}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAtomic(KotlinParser.ExpAtomicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expInfixCall}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpInfixCall(KotlinParser.ExpInfixCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expPostfixUnary}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPostfixUnary(KotlinParser.ExpPostfixUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expTypeOp}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpTypeOp(KotlinParser.ExpTypeOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expInIs}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpInIs(KotlinParser.ExpInIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expComparison}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpComparison(KotlinParser.ExpComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expAssignment}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAssignment(KotlinParser.ExpAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expConjunction}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpConjunction(KotlinParser.ExpConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expEquality}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpEquality(KotlinParser.ExpEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expDisjunction}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpDisjunction(KotlinParser.ExpDisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expRange}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpRange(KotlinParser.ExpRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expMultiplicative}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpMultiplicative(KotlinParser.ExpMultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expPrefixUnary}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPrefixUnary(KotlinParser.ExpPrefixUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expElvis}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpElvis(KotlinParser.ExpElvisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expAdditive}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAdditive(KotlinParser.ExpAdditiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#postfixUnaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixUnaryExpression(KotlinParser.PostfixUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#callableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallableReference(KotlinParser.CallableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpNested}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpNested(KotlinParser.AtomExpNestedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpSingleChild}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpSingleChild(KotlinParser.AtomExpSingleChildContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpThis}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpThis(KotlinParser.AtomExpThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpSuper}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpSuper(KotlinParser.AtomExpSuperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpVariableUse}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpVariableUse(KotlinParser.AtomExpVariableUseContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#labelReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelReference(KotlinParser.LabelReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#labelDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDefinition(KotlinParser.LabelDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#literalConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralConstant(KotlinParser.LiteralConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#stringTemplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringTemplate(KotlinParser.StringTemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#longTemplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongTemplate(KotlinParser.LongTemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(KotlinParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(KotlinParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#blockLevelExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockLevelExpression(KotlinParser.BlockLevelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#multiplicativeOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeOperation(KotlinParser.MultiplicativeOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#additiveOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOperation(KotlinParser.AdditiveOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#inOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInOperation(KotlinParser.InOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeOperation(KotlinParser.TypeOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#isOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOperation(KotlinParser.IsOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#comparisonOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperation(KotlinParser.ComparisonOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#equalityOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityOperation(KotlinParser.EqualityOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(KotlinParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#prefixUnaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixUnaryOperation(KotlinParser.PrefixUnaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#postfixUnaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixUnaryOperation(KotlinParser.PostfixUnaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#callSuffixNoLambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallSuffixNoLambda(KotlinParser.CallSuffixNoLambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#callSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallSuffix(KotlinParser.CallSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#annotatedLambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotatedLambda(KotlinParser.AnnotatedLambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#memberAccessOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccessOperation(KotlinParser.MemberAccessOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(KotlinParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#valueArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueArguments(KotlinParser.ValueArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#valueArgumentElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueArgumentElement(KotlinParser.ValueArgumentElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#jump}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump(KotlinParser.JumpContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionLiteral(KotlinParser.FunctionLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#lambdaParameter_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameter_comma(KotlinParser.LambdaParameter_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#lambdaParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameter(KotlinParser.LambdaParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(KotlinParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#statement_semi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_semi(KotlinParser.Statement_semiContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#constructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorInvocation(KotlinParser.ConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(KotlinParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(KotlinParser.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#parameter_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_comma(KotlinParser.Parameter_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#functiontype_parameter_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiontype_parameter_comma(KotlinParser.Functiontype_parameter_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#type_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_comma(KotlinParser.Type_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#expression_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_comma(KotlinParser.Expression_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#when}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen(KotlinParser.WhenContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#whenEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenEntry(KotlinParser.WhenEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#whenCondition_comma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenCondition_comma(KotlinParser.WhenCondition_commaContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#whenCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenCondition(KotlinParser.WhenConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#annotations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotations(KotlinParser.AnnotationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(KotlinParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#annotationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationList(KotlinParser.AnnotationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#annotationUseSiteTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationUseSiteTarget(KotlinParser.AnnotationUseSiteTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#unescapedAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnescapedAnnotation(KotlinParser.UnescapedAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#simpleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleName(KotlinParser.SimpleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#shortTemplateEntryStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortTemplateEntryStart(KotlinParser.ShortTemplateEntryStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinParser#labelName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelName(KotlinParser.LabelNameContext ctx);
}