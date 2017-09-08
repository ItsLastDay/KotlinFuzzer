// Generated from /home/last/AU/KotlinFuzzer/repo/src/parser/Kotlin.g4 by ANTLR 4.7
package ru.au.kotlinfuzzer.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KotlinParser}.
 */
public interface KotlinListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KotlinParser#kotlinFile}.
	 * @param ctx the parse tree
	 */
	void enterKotlinFile(KotlinParser.KotlinFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#kotlinFile}.
	 * @param ctx the parse tree
	 */
	void exitKotlinFile(KotlinParser.KotlinFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#preamble}.
	 * @param ctx the parse tree
	 */
	void enterPreamble(KotlinParser.PreambleContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#preamble}.
	 * @param ctx the parse tree
	 */
	void exitPreamble(KotlinParser.PreambleContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#import_}.
	 * @param ctx the parse tree
	 */
	void enterImport_(KotlinParser.Import_Context ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#import_}.
	 * @param ctx the parse tree
	 */
	void exitImport_(KotlinParser.Import_Context ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#packageHeader}.
	 * @param ctx the parse tree
	 */
	void enterPackageHeader(KotlinParser.PackageHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#packageHeader}.
	 * @param ctx the parse tree
	 */
	void exitPackageHeader(KotlinParser.PackageHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#simpleName_dot}.
	 * @param ctx the parse tree
	 */
	void enterSimpleName_dot(KotlinParser.SimpleName_dotContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#simpleName_dot}.
	 * @param ctx the parse tree
	 */
	void exitSimpleName_dot(KotlinParser.SimpleName_dotContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void enterModifiers(KotlinParser.ModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void exitModifiers(KotlinParser.ModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#singleModifier}.
	 * @param ctx the parse tree
	 */
	void enterSingleModifier(KotlinParser.SingleModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#singleModifier}.
	 * @param ctx the parse tree
	 */
	void exitSingleModifier(KotlinParser.SingleModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeModifiers}.
	 * @param ctx the parse tree
	 */
	void enterTypeModifiers(KotlinParser.TypeModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeModifiers}.
	 * @param ctx the parse tree
	 */
	void exitTypeModifiers(KotlinParser.TypeModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#singleTypeModifier}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeModifier(KotlinParser.SingleTypeModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#singleTypeModifier}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeModifier(KotlinParser.SingleTypeModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeAlias}.
	 * @param ctx the parse tree
	 */
	void enterTypeAlias(KotlinParser.TypeAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeAlias}.
	 * @param ctx the parse tree
	 */
	void exitTypeAlias(KotlinParser.TypeAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(KotlinParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(KotlinParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(KotlinParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(KotlinParser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#memberModifier}.
	 * @param ctx the parse tree
	 */
	void enterMemberModifier(KotlinParser.MemberModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#memberModifier}.
	 * @param ctx the parse tree
	 */
	void exitMemberModifier(KotlinParser.MemberModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(KotlinParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(KotlinParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#varianceAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterVarianceAnnotation(KotlinParser.VarianceAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#varianceAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitVarianceAnnotation(KotlinParser.VarianceAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#parameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterParameterModifier(KotlinParser.ParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#parameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitParameterModifier(KotlinParser.ParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterModifier(KotlinParser.TypeParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterModifier(KotlinParser.TypeParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#functionModifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionModifier(KotlinParser.FunctionModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#functionModifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionModifier(KotlinParser.FunctionModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#propertyModifier}.
	 * @param ctx the parse tree
	 */
	void enterPropertyModifier(KotlinParser.PropertyModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#propertyModifier}.
	 * @param ctx the parse tree
	 */
	void exitPropertyModifier(KotlinParser.PropertyModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#suspendModifier}.
	 * @param ctx the parse tree
	 */
	void enterSuspendModifier(KotlinParser.SuspendModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#suspendModifier}.
	 * @param ctx the parse tree
	 */
	void exitSuspendModifier(KotlinParser.SuspendModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#topLevelObject}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelObject(KotlinParser.TopLevelObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#topLevelObject}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelObject(KotlinParser.TopLevelObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#class_}.
	 * @param ctx the parse tree
	 */
	void enterClass_(KotlinParser.Class_Context ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#class_}.
	 * @param ctx the parse tree
	 */
	void exitClass_(KotlinParser.Class_Context ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#primaryConstructor}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryConstructor(KotlinParser.PrimaryConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#primaryConstructor}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryConstructor(KotlinParser.PrimaryConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#functionParameter_comma}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameter_comma(KotlinParser.FunctionParameter_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#functionParameter_comma}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameter_comma(KotlinParser.FunctionParameter_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(KotlinParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(KotlinParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#members}.
	 * @param ctx the parse tree
	 */
	void enterMembers(KotlinParser.MembersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#members}.
	 * @param ctx the parse tree
	 */
	void exitMembers(KotlinParser.MembersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#delegationSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDelegationSpecifier(KotlinParser.DelegationSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#delegationSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDelegationSpecifier(KotlinParser.DelegationSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#explicitDelegation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitDelegation(KotlinParser.ExplicitDelegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#explicitDelegation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitDelegation(KotlinParser.ExplicitDelegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(KotlinParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(KotlinParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeParameter_comma}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter_comma(KotlinParser.TypeParameter_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeParameter_comma}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter_comma(KotlinParser.TypeParameter_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(KotlinParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(KotlinParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeConstraints}.
	 * @param ctx the parse tree
	 */
	void enterTypeConstraints(KotlinParser.TypeConstraintsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeConstraints}.
	 * @param ctx the parse tree
	 */
	void exitTypeConstraints(KotlinParser.TypeConstraintsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeConstraint_comma}.
	 * @param ctx the parse tree
	 */
	void enterTypeConstraint_comma(KotlinParser.TypeConstraint_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeConstraint_comma}.
	 * @param ctx the parse tree
	 */
	void exitTypeConstraint_comma(KotlinParser.TypeConstraint_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeConstraint}.
	 * @param ctx the parse tree
	 */
	void enterTypeConstraint(KotlinParser.TypeConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeConstraint}.
	 * @param ctx the parse tree
	 */
	void exitTypeConstraint(KotlinParser.TypeConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#delegationSpecifier_comma}.
	 * @param ctx the parse tree
	 */
	void enterDelegationSpecifier_comma(KotlinParser.DelegationSpecifier_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#delegationSpecifier_comma}.
	 * @param ctx the parse tree
	 */
	void exitDelegationSpecifier_comma(KotlinParser.DelegationSpecifier_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(KotlinParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(KotlinParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#memberDeclaration_inner}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration_inner(KotlinParser.MemberDeclaration_innerContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#memberDeclaration_inner}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration_inner(KotlinParser.MemberDeclaration_innerContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#anonymousInitializer}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousInitializer(KotlinParser.AnonymousInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#anonymousInitializer}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousInitializer(KotlinParser.AnonymousInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#companionObject}.
	 * @param ctx the parse tree
	 */
	void enterCompanionObject(KotlinParser.CompanionObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#companionObject}.
	 * @param ctx the parse tree
	 */
	void exitCompanionObject(KotlinParser.CompanionObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#valueParameters}.
	 * @param ctx the parse tree
	 */
	void enterValueParameters(KotlinParser.ValueParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#valueParameters}.
	 * @param ctx the parse tree
	 */
	void exitValueParameters(KotlinParser.ValueParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameter(KotlinParser.FunctionParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameter(KotlinParser.FunctionParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(KotlinParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(KotlinParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(KotlinParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(KotlinParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(KotlinParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(KotlinParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#variableDeclarationEntry}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationEntry(KotlinParser.VariableDeclarationEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#variableDeclarationEntry}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationEntry(KotlinParser.VariableDeclarationEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#multipleVariableDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterMultipleVariableDeclarations(KotlinParser.MultipleVariableDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#multipleVariableDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitMultipleVariableDeclarations(KotlinParser.MultipleVariableDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#variableDeclarationEntry_comma}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationEntry_comma(KotlinParser.VariableDeclarationEntry_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#variableDeclarationEntry_comma}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationEntry_comma(KotlinParser.VariableDeclarationEntry_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(KotlinParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(KotlinParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#getter}.
	 * @param ctx the parse tree
	 */
	void enterGetter(KotlinParser.GetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#getter}.
	 * @param ctx the parse tree
	 */
	void exitGetter(KotlinParser.GetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#setter}.
	 * @param ctx the parse tree
	 */
	void enterSetter(KotlinParser.SetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#setter}.
	 * @param ctx the parse tree
	 */
	void exitSetter(KotlinParser.SetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(KotlinParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(KotlinParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#functiontype_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctiontype_parameter(KotlinParser.Functiontype_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#functiontype_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctiontype_parameter(KotlinParser.Functiontype_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(KotlinParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(KotlinParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#secondaryConstructor}.
	 * @param ctx the parse tree
	 */
	void enterSecondaryConstructor(KotlinParser.SecondaryConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#secondaryConstructor}.
	 * @param ctx the parse tree
	 */
	void exitSecondaryConstructor(KotlinParser.SecondaryConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#constructorDelegationCall}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDelegationCall(KotlinParser.ConstructorDelegationCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#constructorDelegationCall}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDelegationCall(KotlinParser.ConstructorDelegationCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#enumClassBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumClassBody(KotlinParser.EnumClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#enumClassBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumClassBody(KotlinParser.EnumClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#enumEntries}.
	 * @param ctx the parse tree
	 */
	void enterEnumEntries(KotlinParser.EnumEntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#enumEntries}.
	 * @param ctx the parse tree
	 */
	void exitEnumEntries(KotlinParser.EnumEntriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#enumEntry_comma}.
	 * @param ctx the parse tree
	 */
	void enterEnumEntry_comma(KotlinParser.EnumEntry_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#enumEntry_comma}.
	 * @param ctx the parse tree
	 */
	void exitEnumEntry_comma(KotlinParser.EnumEntry_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#enumEntry}.
	 * @param ctx the parse tree
	 */
	void enterEnumEntry(KotlinParser.EnumEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#enumEntry}.
	 * @param ctx the parse tree
	 */
	void exitEnumEntry(KotlinParser.EnumEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(KotlinParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(KotlinParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeReference}.
	 * @param ctx the parse tree
	 */
	void enterTypeReference(KotlinParser.TypeReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeReference}.
	 * @param ctx the parse tree
	 */
	void exitTypeReference(KotlinParser.TypeReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeReferenceNonNullable}.
	 * @param ctx the parse tree
	 */
	void enterTypeReferenceNonNullable(KotlinParser.TypeReferenceNonNullableContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeReferenceNonNullable}.
	 * @param ctx the parse tree
	 */
	void exitTypeReferenceNonNullable(KotlinParser.TypeReferenceNonNullableContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#nullableType}.
	 * @param ctx the parse tree
	 */
	void enterNullableType(KotlinParser.NullableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#nullableType}.
	 * @param ctx the parse tree
	 */
	void exitNullableType(KotlinParser.NullableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#funcReceiverType}.
	 * @param ctx the parse tree
	 */
	void enterFuncReceiverType(KotlinParser.FuncReceiverTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#funcReceiverType}.
	 * @param ctx the parse tree
	 */
	void exitFuncReceiverType(KotlinParser.FuncReceiverTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#userType}.
	 * @param ctx the parse tree
	 */
	void enterUserType(KotlinParser.UserTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#userType}.
	 * @param ctx the parse tree
	 */
	void exitUserType(KotlinParser.UserTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#simpleUserType_dot}.
	 * @param ctx the parse tree
	 */
	void enterSimpleUserType_dot(KotlinParser.SimpleUserType_dotContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#simpleUserType_dot}.
	 * @param ctx the parse tree
	 */
	void exitSimpleUserType_dot(KotlinParser.SimpleUserType_dotContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#simpleUserType}.
	 * @param ctx the parse tree
	 */
	void enterSimpleUserType(KotlinParser.SimpleUserTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#simpleUserType}.
	 * @param ctx the parse tree
	 */
	void exitSimpleUserType(KotlinParser.SimpleUserTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#optProjection_usertype}.
	 * @param ctx the parse tree
	 */
	void enterOptProjection_usertype(KotlinParser.OptProjection_usertypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#optProjection_usertype}.
	 * @param ctx the parse tree
	 */
	void exitOptProjection_usertype(KotlinParser.OptProjection_usertypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#optProjection_elem}.
	 * @param ctx the parse tree
	 */
	void enterOptProjection_elem(KotlinParser.OptProjection_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#optProjection_elem}.
	 * @param ctx the parse tree
	 */
	void exitOptProjection_elem(KotlinParser.OptProjection_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#optionalProjection}.
	 * @param ctx the parse tree
	 */
	void enterOptionalProjection(KotlinParser.OptionalProjectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#optionalProjection}.
	 * @param ctx the parse tree
	 */
	void exitOptionalProjection(KotlinParser.OptionalProjectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(KotlinParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(KotlinParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#controlStructureBody}.
	 * @param ctx the parse tree
	 */
	void enterControlStructureBody(KotlinParser.ControlStructureBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#controlStructureBody}.
	 * @param ctx the parse tree
	 */
	void exitControlStructureBody(KotlinParser.ControlStructureBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#if_}.
	 * @param ctx the parse tree
	 */
	void enterIf_(KotlinParser.If_Context ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#if_}.
	 * @param ctx the parse tree
	 */
	void exitIf_(KotlinParser.If_Context ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#try_}.
	 * @param ctx the parse tree
	 */
	void enterTry_(KotlinParser.Try_Context ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#try_}.
	 * @param ctx the parse tree
	 */
	void exitTry_(KotlinParser.Try_Context ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#catchBlock}.
	 * @param ctx the parse tree
	 */
	void enterCatchBlock(KotlinParser.CatchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#catchBlock}.
	 * @param ctx the parse tree
	 */
	void exitCatchBlock(KotlinParser.CatchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(KotlinParser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(KotlinParser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(KotlinParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(KotlinParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#for_}.
	 * @param ctx the parse tree
	 */
	void enterFor_(KotlinParser.For_Context ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#for_}.
	 * @param ctx the parse tree
	 */
	void exitFor_(KotlinParser.For_Context ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#while_}.
	 * @param ctx the parse tree
	 */
	void enterWhile_(KotlinParser.While_Context ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#while_}.
	 * @param ctx the parse tree
	 */
	void exitWhile_(KotlinParser.While_Context ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#doWhile}.
	 * @param ctx the parse tree
	 */
	void enterDoWhile(KotlinParser.DoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#doWhile}.
	 * @param ctx the parse tree
	 */
	void exitDoWhile(KotlinParser.DoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expAtomic}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpAtomic(KotlinParser.ExpAtomicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expAtomic}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpAtomic(KotlinParser.ExpAtomicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expInfixCall}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpInfixCall(KotlinParser.ExpInfixCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expInfixCall}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpInfixCall(KotlinParser.ExpInfixCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expPostfixUnary}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpPostfixUnary(KotlinParser.ExpPostfixUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expPostfixUnary}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpPostfixUnary(KotlinParser.ExpPostfixUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expTypeOp}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpTypeOp(KotlinParser.ExpTypeOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expTypeOp}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpTypeOp(KotlinParser.ExpTypeOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expInIs}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpInIs(KotlinParser.ExpInIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expInIs}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpInIs(KotlinParser.ExpInIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expComparison}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpComparison(KotlinParser.ExpComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expComparison}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpComparison(KotlinParser.ExpComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expAssignment}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpAssignment(KotlinParser.ExpAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expAssignment}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpAssignment(KotlinParser.ExpAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expConjunction}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpConjunction(KotlinParser.ExpConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expConjunction}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpConjunction(KotlinParser.ExpConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expEquality}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpEquality(KotlinParser.ExpEqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expEquality}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpEquality(KotlinParser.ExpEqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expDisjunction}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpDisjunction(KotlinParser.ExpDisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expDisjunction}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpDisjunction(KotlinParser.ExpDisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expRange}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpRange(KotlinParser.ExpRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expRange}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpRange(KotlinParser.ExpRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expMultiplicative}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpMultiplicative(KotlinParser.ExpMultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expMultiplicative}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpMultiplicative(KotlinParser.ExpMultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expPrefixUnary}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpPrefixUnary(KotlinParser.ExpPrefixUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expPrefixUnary}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpPrefixUnary(KotlinParser.ExpPrefixUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expElvis}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpElvis(KotlinParser.ExpElvisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expElvis}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpElvis(KotlinParser.ExpElvisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expAdditive}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpAdditive(KotlinParser.ExpAdditiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expAdditive}
	 * labeled alternative in {@link KotlinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpAdditive(KotlinParser.ExpAdditiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#postfixUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixUnaryExpression(KotlinParser.PostfixUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#postfixUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixUnaryExpression(KotlinParser.PostfixUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#callableReference}.
	 * @param ctx the parse tree
	 */
	void enterCallableReference(KotlinParser.CallableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#callableReference}.
	 * @param ctx the parse tree
	 */
	void exitCallableReference(KotlinParser.CallableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpNested}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpNested(KotlinParser.AtomExpNestedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpNested}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpNested(KotlinParser.AtomExpNestedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpSingleChild}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpSingleChild(KotlinParser.AtomExpSingleChildContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpSingleChild}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpSingleChild(KotlinParser.AtomExpSingleChildContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpThis}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpThis(KotlinParser.AtomExpThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpThis}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpThis(KotlinParser.AtomExpThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpSuper}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpSuper(KotlinParser.AtomExpSuperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpSuper}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpSuper(KotlinParser.AtomExpSuperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpVariableUse}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpVariableUse(KotlinParser.AtomExpVariableUseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpVariableUse}
	 * labeled alternative in {@link KotlinParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpVariableUse(KotlinParser.AtomExpVariableUseContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#labelReference}.
	 * @param ctx the parse tree
	 */
	void enterLabelReference(KotlinParser.LabelReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#labelReference}.
	 * @param ctx the parse tree
	 */
	void exitLabelReference(KotlinParser.LabelReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#labelDefinition}.
	 * @param ctx the parse tree
	 */
	void enterLabelDefinition(KotlinParser.LabelDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#labelDefinition}.
	 * @param ctx the parse tree
	 */
	void exitLabelDefinition(KotlinParser.LabelDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#literalConstant}.
	 * @param ctx the parse tree
	 */
	void enterLiteralConstant(KotlinParser.LiteralConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#literalConstant}.
	 * @param ctx the parse tree
	 */
	void exitLiteralConstant(KotlinParser.LiteralConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#stringTemplate}.
	 * @param ctx the parse tree
	 */
	void enterStringTemplate(KotlinParser.StringTemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#stringTemplate}.
	 * @param ctx the parse tree
	 */
	void exitStringTemplate(KotlinParser.StringTemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#longTemplate}.
	 * @param ctx the parse tree
	 */
	void enterLongTemplate(KotlinParser.LongTemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#longTemplate}.
	 * @param ctx the parse tree
	 */
	void exitLongTemplate(KotlinParser.LongTemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(KotlinParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(KotlinParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(KotlinParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(KotlinParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#blockLevelExpression}.
	 * @param ctx the parse tree
	 */
	void enterBlockLevelExpression(KotlinParser.BlockLevelExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#blockLevelExpression}.
	 * @param ctx the parse tree
	 */
	void exitBlockLevelExpression(KotlinParser.BlockLevelExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#multiplicativeOperation}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeOperation(KotlinParser.MultiplicativeOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#multiplicativeOperation}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeOperation(KotlinParser.MultiplicativeOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#additiveOperation}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveOperation(KotlinParser.AdditiveOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#additiveOperation}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveOperation(KotlinParser.AdditiveOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#inOperation}.
	 * @param ctx the parse tree
	 */
	void enterInOperation(KotlinParser.InOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#inOperation}.
	 * @param ctx the parse tree
	 */
	void exitInOperation(KotlinParser.InOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeOperation}.
	 * @param ctx the parse tree
	 */
	void enterTypeOperation(KotlinParser.TypeOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeOperation}.
	 * @param ctx the parse tree
	 */
	void exitTypeOperation(KotlinParser.TypeOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#isOperation}.
	 * @param ctx the parse tree
	 */
	void enterIsOperation(KotlinParser.IsOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#isOperation}.
	 * @param ctx the parse tree
	 */
	void exitIsOperation(KotlinParser.IsOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#comparisonOperation}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperation(KotlinParser.ComparisonOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#comparisonOperation}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperation(KotlinParser.ComparisonOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#equalityOperation}.
	 * @param ctx the parse tree
	 */
	void enterEqualityOperation(KotlinParser.EqualityOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#equalityOperation}.
	 * @param ctx the parse tree
	 */
	void exitEqualityOperation(KotlinParser.EqualityOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(KotlinParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(KotlinParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#prefixUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterPrefixUnaryOperation(KotlinParser.PrefixUnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#prefixUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitPrefixUnaryOperation(KotlinParser.PrefixUnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#postfixUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterPostfixUnaryOperation(KotlinParser.PostfixUnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#postfixUnaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitPostfixUnaryOperation(KotlinParser.PostfixUnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#callSuffixNoLambda}.
	 * @param ctx the parse tree
	 */
	void enterCallSuffixNoLambda(KotlinParser.CallSuffixNoLambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#callSuffixNoLambda}.
	 * @param ctx the parse tree
	 */
	void exitCallSuffixNoLambda(KotlinParser.CallSuffixNoLambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#callSuffix}.
	 * @param ctx the parse tree
	 */
	void enterCallSuffix(KotlinParser.CallSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#callSuffix}.
	 * @param ctx the parse tree
	 */
	void exitCallSuffix(KotlinParser.CallSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#annotatedLambda}.
	 * @param ctx the parse tree
	 */
	void enterAnnotatedLambda(KotlinParser.AnnotatedLambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#annotatedLambda}.
	 * @param ctx the parse tree
	 */
	void exitAnnotatedLambda(KotlinParser.AnnotatedLambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#memberAccessOperation}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessOperation(KotlinParser.MemberAccessOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#memberAccessOperation}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessOperation(KotlinParser.MemberAccessOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(KotlinParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(KotlinParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#valueArguments}.
	 * @param ctx the parse tree
	 */
	void enterValueArguments(KotlinParser.ValueArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#valueArguments}.
	 * @param ctx the parse tree
	 */
	void exitValueArguments(KotlinParser.ValueArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#valueArgumentElement}.
	 * @param ctx the parse tree
	 */
	void enterValueArgumentElement(KotlinParser.ValueArgumentElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#valueArgumentElement}.
	 * @param ctx the parse tree
	 */
	void exitValueArgumentElement(KotlinParser.ValueArgumentElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#jump}.
	 * @param ctx the parse tree
	 */
	void enterJump(KotlinParser.JumpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#jump}.
	 * @param ctx the parse tree
	 */
	void exitJump(KotlinParser.JumpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFunctionLiteral(KotlinParser.FunctionLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFunctionLiteral(KotlinParser.FunctionLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#lambdaParameter_comma}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameter_comma(KotlinParser.LambdaParameter_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#lambdaParameter_comma}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameter_comma(KotlinParser.LambdaParameter_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameter(KotlinParser.LambdaParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#lambdaParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameter(KotlinParser.LambdaParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(KotlinParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(KotlinParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#statement_semi}.
	 * @param ctx the parse tree
	 */
	void enterStatement_semi(KotlinParser.Statement_semiContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#statement_semi}.
	 * @param ctx the parse tree
	 */
	void exitStatement_semi(KotlinParser.Statement_semiContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#constructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterConstructorInvocation(KotlinParser.ConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#constructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitConstructorInvocation(KotlinParser.ConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(KotlinParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(KotlinParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(KotlinParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(KotlinParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#parameter_comma}.
	 * @param ctx the parse tree
	 */
	void enterParameter_comma(KotlinParser.Parameter_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#parameter_comma}.
	 * @param ctx the parse tree
	 */
	void exitParameter_comma(KotlinParser.Parameter_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#functiontype_parameter_comma}.
	 * @param ctx the parse tree
	 */
	void enterFunctiontype_parameter_comma(KotlinParser.Functiontype_parameter_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#functiontype_parameter_comma}.
	 * @param ctx the parse tree
	 */
	void exitFunctiontype_parameter_comma(KotlinParser.Functiontype_parameter_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#type_comma}.
	 * @param ctx the parse tree
	 */
	void enterType_comma(KotlinParser.Type_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#type_comma}.
	 * @param ctx the parse tree
	 */
	void exitType_comma(KotlinParser.Type_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#expression_comma}.
	 * @param ctx the parse tree
	 */
	void enterExpression_comma(KotlinParser.Expression_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#expression_comma}.
	 * @param ctx the parse tree
	 */
	void exitExpression_comma(KotlinParser.Expression_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#when}.
	 * @param ctx the parse tree
	 */
	void enterWhen(KotlinParser.WhenContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#when}.
	 * @param ctx the parse tree
	 */
	void exitWhen(KotlinParser.WhenContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#whenEntry}.
	 * @param ctx the parse tree
	 */
	void enterWhenEntry(KotlinParser.WhenEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#whenEntry}.
	 * @param ctx the parse tree
	 */
	void exitWhenEntry(KotlinParser.WhenEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#whenCondition_comma}.
	 * @param ctx the parse tree
	 */
	void enterWhenCondition_comma(KotlinParser.WhenCondition_commaContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#whenCondition_comma}.
	 * @param ctx the parse tree
	 */
	void exitWhenCondition_comma(KotlinParser.WhenCondition_commaContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#whenCondition}.
	 * @param ctx the parse tree
	 */
	void enterWhenCondition(KotlinParser.WhenConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#whenCondition}.
	 * @param ctx the parse tree
	 */
	void exitWhenCondition(KotlinParser.WhenConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#annotations}.
	 * @param ctx the parse tree
	 */
	void enterAnnotations(KotlinParser.AnnotationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#annotations}.
	 * @param ctx the parse tree
	 */
	void exitAnnotations(KotlinParser.AnnotationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(KotlinParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(KotlinParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#annotationList}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationList(KotlinParser.AnnotationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#annotationList}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationList(KotlinParser.AnnotationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#annotationUseSiteTarget}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationUseSiteTarget(KotlinParser.AnnotationUseSiteTargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#annotationUseSiteTarget}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationUseSiteTarget(KotlinParser.AnnotationUseSiteTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#unescapedAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterUnescapedAnnotation(KotlinParser.UnescapedAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#unescapedAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitUnescapedAnnotation(KotlinParser.UnescapedAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#simpleName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleName(KotlinParser.SimpleNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#simpleName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleName(KotlinParser.SimpleNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#shortTemplateEntryStart}.
	 * @param ctx the parse tree
	 */
	void enterShortTemplateEntryStart(KotlinParser.ShortTemplateEntryStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#shortTemplateEntryStart}.
	 * @param ctx the parse tree
	 */
	void exitShortTemplateEntryStart(KotlinParser.ShortTemplateEntryStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#labelName}.
	 * @param ctx the parse tree
	 */
	void enterLabelName(KotlinParser.LabelNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#labelName}.
	 * @param ctx the parse tree
	 */
	void exitLabelName(KotlinParser.LabelNameContext ctx);
}