grammar Kotlin;


QuotedString: '"' .*? '"' ;


NoEscapeString : LONG_STRING ;


kotlinFile
  : SEMI* preamble SEMI* (topLevelObject SEMI*)*
  ;

preamble
  : packageHeader? SEMI* import_*
  ;

import_
  : KW_IMPORT simpleName_dot (isImportAll='.*' |KW_AS simpleName)? SEMI*
  ;

packageHeader
  : modifiers KW_PACKAGE simpleName_dot SEMI?
  ;

simpleName_dot: simpleName ('.' simpleName)* ;


modifiers
  : SEMI* (singleModifier SEMI*)*
  ;

singleModifier
  : modifier
  | annotation
  | annotationList
  ;

typeModifiers
  : singleTypeModifier*
  ;

singleTypeModifier
  : suspendModifier
  | (annotation | annotationList)+
  ;

typeAlias
  : modifiers KW_TYPEALIAS simpleName typeParameters? '=' type
  ;

modifier
  : classModifier
  | accessModifier
  | varianceAnnotation
  | memberModifier
  | parameterModifier
  | typeParameterModifier
  | functionModifier
  | propertyModifier
  ;

classModifier
  : KW_ABSTRACT
  | KW_FINAL
  | KW_ENUM
  | KW_OPEN
  | KW_ANNOTATION
  | KW_SEALED
  | KW_DATA
  | KW_INNER
  ;

memberModifier
  : KW_OVERRIDE
  | KW_OPEN
  | KW_FINAL
  | KW_ABSTRACT
  | KW_LATEINIT
  ;
accessModifier
  : KW_PRIVATE
  | KW_PROTECTED
  | KW_PUBLIC
  | KW_INTERNAL
  ;
varianceAnnotation
  : KW_IN
  | KW_OUT
  ;
parameterModifier
  : KW_NOINLINE
  | KW_CROSSINLINE
  | KW_VARARG
  ;
typeParameterModifier
  : KW_REIFIED
  ;
functionModifier
  : KW_TAILREC
  | KW_OPERATOR
  | KW_INFIX
  | KW_INLINE
  | KW_EXTERNAL
  | suspendModifier
  ;
propertyModifier
  : KW_CONST
  ;
suspendModifier
  : KW_SUSPEND
  ;


topLevelObject
  : class_
  | object
  | function
  | property
  | typeAlias
  ;


class_
  : modifiers (KW_CLASS | KW_INTERFACE) simpleName
      typeParameters?
      primaryConstructor?
      (':' annotations delegationSpecifier_comma)?
      typeConstraints
      (classBody? | enumClassBody)
  ;

// version without '?' after functionParameter_comma is
// inconsistent with Kotlin parser:
// https://github.com/JetBrains/kotlin/blob/3471b3311f8358a14ab21d957c6137a84615484a/compiler/frontend/src/org/jetbrains/kotlin/parsing/KotlinParsing.java#L2141
primaryConstructor
  : (modifiers KW_CONSTRUCTOR)? '(' functionParameter_comma? ')'
  ;

functionParameter_comma: SEMI* functionParameter SEMI* (',' SEMI* functionParameter SEMI*)* ;

classBody
  : SEMI* '{' members '}' SEMI*
  ;

members
  : SEMI* (memberDeclaration SEMI*)*
  ;

delegationSpecifier
  : constructorInvocation
  | userType
  | explicitDelegation
  ;
explicitDelegation
  : userType KW_BY expression
  ;
typeParameters
  : '<' typeParameter_comma '>'
  ;

typeParameter_comma: SEMI* typeParameter SEMI* (',' SEMI* typeParameter SEMI*)* ;

typeParameter
  : modifiers simpleName (':' userType)?
  ;


typeConstraints
  : (KW_WHERE typeConstraint_comma)?
  ;

typeConstraint_comma: SEMI* typeConstraint SEMI* (',' SEMI* typeConstraint SEMI*)* ;

typeConstraint
  : annotations simpleName ':' type
  ;

delegationSpecifier_comma: SEMI* delegationSpecifier SEMI* (',' SEMI* delegationSpecifier SEMI*)* ;



memberDeclaration
  : SEMI* memberDeclaration_inner SEMI*
  ;

memberDeclaration_inner
  : companionObject
  | object
  | function
  | property
  | class_
  | typeAlias
  | anonymousInitializer
  | secondaryConstructor
  ;


anonymousInitializer
  : KW_INIT block
  ;

companionObject
  : modifiers KW_COMPANION KW_OBJECT simpleName? (':' delegationSpecifier_comma)? classBody?
  ;


valueParameters
  : '(' SEMI* functionParameter_comma? SEMI* ')'
  ;

functionParameter
  : modifiers (KW_VAL | KW_VAR)? parameter ('=' expression)?
  ;

block
  : SEMI* '{' statements '}' SEMI*
  ;

function
  : modifiers KW_FUN
      genericParams=typeParameters?
      (receiverType=type '.')?
      simpleName
      typeParameters? valueParameters (':' returnType=type)?
      typeConstraints
      functionBody?
  ;

functionBody
  : block
  | SEMI* '=' SEMI* expression
  ;

variableDeclarationEntry
  : simpleName (':' type)?
  ;

multipleVariableDeclarations
  : '(' variableDeclarationEntry_comma ')'
  ;

variableDeclarationEntry_comma: SEMI* variableDeclarationEntry SEMI* (',' SEMI* variableDeclarationEntry SEMI*)* ;

property
  : modifiers (KW_VAL | KW_VAR)
      typeParameters?
      (type '.')?
      (multipleVariableDeclarations // Destructuring declaration
        | variableDeclarationEntry)
      typeConstraints
      // Differs from Kotlin grammar: 'by' and '=' are interchangable.
      ((KW_BY | '=') expression SEMI*)?
      (getter? setter? | setter? getter?) SEMI*
  ;


getter
  : modifiers KW_GET
  | modifiers KW_GET '(' ')' (':' type)? functionBody
  ;

setter
  : modifiers KW_SET
  | modifiers KW_SET '(' modifiers (simpleName | parameter) ')' functionBody
  ;

parameter
  : simpleName ':' type
  ;

functiontype_parameter
  : (simpleName ':')? type
  ;

object
  : KW_OBJECT simpleName primaryConstructor? (':' delegationSpecifier_comma)? classBody?
  ;

// Differs from kotlin grammar: allow constructors without body (that only delegate)
secondaryConstructor
  : modifiers KW_CONSTRUCTOR valueParameters (':' constructorDelegationCall)? block? SEMI*
  ;

constructorDelegationCall
  : KW_THIS valueArguments
  | KW_SUPER valueArguments
  ;


enumClassBody
  : '{' enumEntries memberDeclaration* '}'
  ;

enumEntries
  : SEMI* (enumEntry_comma ','? SEMI*)?
  ;

enumEntry_comma: SEMI* enumEntry SEMI* (',' SEMI* enumEntry SEMI*)* ;

// Differs from kotlin grammar: garbage rule `arguments` is presented there
enumEntry
  : modifiers simpleName valueArguments? classBody?
  ;

type
  : typeModifiers typeReference
  ;

typeReference
  : typeReferenceNonNullable
  | nullableType
  ;

// This rule is used to avoid mutual left recursion of nullable and non-nullable types.
typeReferenceNonNullable
  : '(' typeReference ')' // Actually can be nullable
  | KW_DYNAMIC
  | functionType
  | userType
  ;

nullableType
  : typeReferenceNonNullable '?'+
  ;

// This rule is used to avoid mutual left recursion in `functionType` rule.
// 'typeModifiers' from 'type' is included here
// '?'? from 'nullableType' is included here
funcReceiverType
  : typeModifiers
      ('(' typeReference ')'
        | KW_DYNAMIC
        | userType)
      nullability='?'?
  ;

userType
  : simpleUserType_dot
  ;

simpleUserType_dot: simpleUserType ('.' simpleUserType)* ;


simpleUserType
  : simpleName ('<' optProjection_usertype '>')?
  ;

optProjection_usertype
 : SEMI* optProjection_elem SEMI* (',' SEMI* optProjection_elem SEMI*)*
 ;

optProjection_elem
 : optionalProjection type
 | '*'
 ;

// Differs from Kotlin grammar: added "?" so it is really optional.
optionalProjection
  : varianceAnnotation?
  ;

// Differs from Kotlin grammar: use 'functiontype_parameter' instead of 'parameter'.
// 'functiontype_parameter' is my own definition, which is almost like 'parameter', but
// has optional name and ':'.
// Function types in Kotlin may omit names: "(Int, x: String) -> Unit" is a valid function type.
functionType
  : (funcReceiverType '.')? '(' functiontype_parameter_comma? ')' '->' type?
  ;


controlStructureBody
  : block
  | blockLevelExpression
  ;

// Differs from Kotlin grammar: `thenBlock` is optional when "if" is not an expression.
if_
  : KW_IF '(' expression ')' thenBlock=controlStructureBody? (KW_ELSE elseBlock=controlStructureBody)?
  ;

try_
  : KW_TRY block SEMI* (catchBlock SEMI*)* SEMI* finallyBlock?
  ;

catchBlock
  : KW_CATCH '(' annotations simpleName ':' userType ')' block
  ;

finallyBlock
  : KW_FINALLY block
  ;

loop
  : for_
  | while_
  | doWhile
  ;

for_
  : KW_FOR '(' annotations (multipleVariableDeclarations | variableDeclarationEntry) KW_IN expression ')' controlStructureBody
  ;

// Differs from kotlin grammar (due to my limitations): prohibit empty while-s
// This is because "while (1) { smth }" can be parsed as [while (1); callSuffix].
while_
  : KW_WHILE '(' expression ')' controlStructureBody
  ;

doWhile
  : KW_DO controlStructureBody KW_WHILE '(' expression ')'
  ;



expression
  : expression SEMI* (typeOperation | isOperation) SEMI* type  # expTypeOp
  | expression  SEMI* multiplicativeOperation SEMI*  expression # expMultiplicative
  | expression  SEMI* additiveOperation SEMI*  expression # expAdditive
  | expression  SEMI* '..' SEMI*  expression # expRange
  | expression simpleName expression # expInfixCall
  // '?' and ':' need to be separate, so that cases like "Any?::extension" are parsed correctly.
  | expression  SEMI* '?' ':' SEMI*  expression # expElvis
  | expression  SEMI* inOperation SEMI*  expression # expInIs
  | expression  SEMI* comparisonOperation SEMI*  expression # expComparison
  | expression  SEMI* equalityOperation SEMI*  expression # expEquality
  | expression  SEMI* '&&' expression  SEMI*   # expConjunction
  | expression  SEMI* '||' expression SEMI*    # expDisjunction
  | expression  SEMI* assignmentOperator SEMI*  expression    # expAssignment
  | prefixUnaryOperation expression # expPrefixUnary
  | postfixUnaryExpression # expPostfixUnary
  | atomicExpression  # expAtomic
  ;

postfixUnaryExpression
  : atomicExpression postfixUnaryOperation+
  | callableReference postfixUnaryOperation*
  ;

callableReference
  : (userType nullable='?'*)? '::' simpleName typeArguments?
  ;

atomicExpression
  : '(' expression ')'  # atomExpNested
  | literalConstant # atomExpSingleChild
  | functionLiteral # atomExpSingleChild
  | KW_THIS labelReference?                   # atomExpThis
  | KW_SUPER ('<' type '>')? labelReference?  # atomExpSuper
  | if_             # atomExpSingleChild
  | when            # atomExpSingleChild
  | try_            # atomExpSingleChild
  | objectLiteral   # atomExpSingleChild
  | jump            # atomExpSingleChild
  | loop            # atomExpSingleChild
  | simpleName      # atomExpVariableUse
  ;

labelReference
  : '@' labelName
  ;

labelDefinition
  : labelName '@'
  ;

literalConstant
  : KW_TRUE | KW_FALSE
  | stringTemplate
  | NoEscapeString
  | IntegerLiteral
  | HexadecimalLiteral
  | CharacterLiteral
  | FloatLiteral
  | DecimalFloatingEndingDot
  | DecimalFloatingStartingDot
  | KW_NULL
  ;

stringTemplate
  // Differs from Kotlin grammar because it adds subtle bugs to my grammar.
  // Just allow every quoted string.
  //: '"' stringTemplateElement* '"'
  : QuotedString
  ;
/*
stringTemplateElement
  : RegularStringPart
  | shortTemplateEntryStart (simpleName | KW_THIS)
  | EscapeSequence
  | longTemplate
  ;*/

longTemplate
  : '${' expression '}'
  ;

declaration
  : function
  | property
  | class_
  | typeAlias
  | object
  ;

statement
  : declaration
  | blockLevelExpression
  ;

blockLevelExpression
  : SEMI* annotations SEMI* expression SEMI*
  ;

multiplicativeOperation
  : '*' | '/' | '%'
  ;
additiveOperation
  : '+' | '-'
  ;
inOperation
  : KW_IN | KW_NOT_IN
  ;
typeOperation
  : KW_AS | 'as?' | ':'
  ;
isOperation
  : KW_IS | KW_NOT_IS
  ;
comparisonOperation
  : '<' | '>' | '>=' | '<='
  ;
equalityOperation
  : '!=' | '=='
  // Differs from kotlin grammar: added referential equality
  | '!==' | '==='
  ;
assignmentOperator
  : '='
  | '+=' | '-=' | '*=' | '/=' | '%='
  ;
prefixUnaryOperation
  : '-' | '+'
  | '++' | '--'
  | '!'
  | (annotation | annotationList)
  | labelDefinition
  ;

postfixUnaryOperation
  : '++' | '--' | '!!'
  | callSuffix
  | arrayAccess
  | SEMI* memberAccessOperation SEMI* (postfixUnaryExpression | atomicExpression)
  ;


// Differs from Kotlin grammar: deleted `annotatedLambda`, because I don't know how it is used.
callSuffixNoLambda: typeArguments? valueArguments ;

callSuffix
  : callSuffixNoLambda
// Differs from Kotlin grammar to parse smth like
// fun foo() {
//       a1.filter { (x, y) -> }
//       a2.filter { (x) -> }
// }
  | typeArguments? annotatedLambda
  ;

annotatedLambda
  : ('@' unescapedAnnotation SEMI*)* labelDefinition? functionLiteral
  ;

// Separate '?' '.' here, so that code like
// "fun Any?.ext() {}"
// is lexed as [SimpleName, '?', '.'] -> parsed as [nullableType, '.']
// instead of [SimpleName, '?.'] -> not parsed.
// Differs from kotlin grammar: deleted plain '?' alternative, because I don't know how it is used,
// but it disturbs parsing of smth like "Any?::ext".
memberAccessOperation
  : '.' | '?' '.'
  ;

typeArguments
  : '<' type_comma '>'
  ;


// Differs from Kotlin grammar: allow named arguments, allow zero arguments.
valueArguments
  : '(' SEMI* valueArgumentElement SEMI* (',' SEMI* valueArgumentElement SEMI*)*')'
  | '(' SEMI* ')'
  ;

valueArgumentElement
  : (simpleName '=')? unpack='*'? expression
  ;

jump
  : KW_THROW expression
  | KW_RETURN labelReference? expression?
  | KW_CONTINUE labelReference?
  | KW_BREAK labelReference?
  ;

functionLiteral
  : '{' statements '}'
  | '{' lambdaParameter_comma '->' statements '}'
  ;

lambdaParameter_comma
    : SEMI* lambdaParameter SEMI* (',' SEMI* lambdaParameter SEMI*)*
    |
    ;

lambdaParameter
  : variableDeclarationEntry
  | multipleVariableDeclarations (':' type)?
  ;


// Kotlin parser seem to allow empty statements
// https://github.com/JetBrains/kotlin/blob/master/compiler/frontend/src/org/jetbrains/kotlin/parsing/KotlinExpressionParsing.java#L1263
statements
  : SEMI* statement_semi SEMI*
  | SEMI*
  ;

statement_semi: statement (SEMI+ statement)* ;

constructorInvocation
  : userType callSuffixNoLambda
  ;

arrayAccess
  : '[' expression_comma ']'
  ;

// Differs from kotlin grammar (due to my limitations): prohibit empty objects (without body).
// This is because "object { smth }" can be parsed as [empty object; call suffix].
objectLiteral
  : KW_OBJECT (':' delegationSpecifier_comma)? classBody
  ;

parameter_comma: SEMI* parameter SEMI* (',' SEMI* parameter SEMI*)* ;

functiontype_parameter_comma: SEMI* functiontype_parameter SEMI* (',' SEMI* functiontype_parameter SEMI*)* ;

type_comma: SEMI* type SEMI* (',' SEMI* type SEMI*)* ;

expression_comma: SEMI* expression SEMI* (',' SEMI* expression SEMI*)* ;


when
  : KW_WHEN ('(' expression ')')? '{'
        SEMI*
        whenEntry*
        SEMI*
    '}'
  ;

whenEntry
  : whenCondition_comma SEMI* '->' SEMI* controlStructureBody SEMI+
  | KW_ELSE SEMI* '->' SEMI* controlStructureBody SEMI+
  ;

whenCondition_comma: SEMI* whenCondition SEMI* (',' SEMI* whenCondition SEMI*)* ;

whenCondition
  : expression
  | (KW_IN | KW_NOT_IN) expression
  | (KW_IS | KW_NOT_IS) type
  ;


annotations
  : (annotation | annotationList)*
  ;
annotation
  : '@' (annotationUseSiteTarget ':')? SEMI* unescapedAnnotation SEMI*
  ;
annotationList
  : '@' (annotationUseSiteTarget ':')? SEMI* '[' unescapedAnnotation+ ']' SEMI*
  ;
annotationUseSiteTarget
  : KW_FIELD
  | KW_FILE
  | KW_PROPERTY
  | KW_GET
  | KW_SET
  | KW_RECEIVER
  | KW_PARAM
  | KW_SETPARAM
  | KW_DELEGATE
  ;
unescapedAnnotation
  : simpleName_dot typeArguments? valueArguments?
  ;


KW_CONST : 'const' ;
KW_CLASS : 'class' ;
KW_LATEINIT : 'lateinit' ;
KW_CATCH : 'catch' ;
KW_AS : 'as' ;
KW_ANNOTATION : 'annotation' ;
KW_SUSPEND : 'suspend' ;
KW_NOINLINE : 'noinline' ;
KW_FOR : 'for' ;
KW_DELEGATE : 'delegate' ;
KW_SETPARAM : 'setparam' ;
KW_OUT : 'out' ;
KW_BREAK : 'break' ;
KW_WHILE : 'while' ;
KW_WHERE : 'where' ;
KW_COMPANION : 'companion' ;
KW_SUPER : 'super' ;
KW_VAR : 'var' ;
KW_ENUM : 'enum' ;
KW_SEALED : 'sealed' ;
KW_FIELD : 'field' ;
KW_PROPERTY : 'property' ;
KW_IMPORT : 'import' ;
KW_CONSTRUCTOR : 'constructor' ;
KW_INTERFACE : 'interface' ;
KW_VAL : 'val' ;
KW_PUBLIC : 'public' ;
KW_NULL : 'null' ;
KW_INTERNAL : 'internal' ;
KW_PACKAGE : 'package' ;
KW_TAILREC : 'tailrec' ;
KW_BY : 'by' ;
KW_OPERATOR : 'operator' ;
KW_FUN : 'fun' ;
KW_ELSE : 'else' ;
KW_CROSSINLINE : 'crossinline' ;
KW_THIS : 'this' ;
KW_DYNAMIC : 'dynamic' ;
KW_TRUE : 'true' ;
KW_IF : 'if' ;
KW_INFIX : 'infix' ;
KW_FINALLY : 'finally' ;
KW_DO : 'do' ;
KW_MODIFIERS : 'modifiers' ;
KW_RETURN : 'return' ;
KW_PARAM : 'param' ;
KW_SET : 'set' ;
KW_IN : 'in' ;
KW_NOT_IN : '!in' ;
KW_TYPEALIAS : 'typealias' ;
KW_TRY : 'try' ;
KW_IS : 'is' ;
KW_NOT_IS : '!is' ;
KW_DATA : 'data' ;
KW_INIT : 'init' ;
KW_FALSE : 'false' ;
KW_REIFIED : 'reified' ;
KW_FINAL : 'final' ;
KW_CONTINUE : 'continue' ;
KW_INLINE : 'inline' ;
KW_EXTERNAL : 'external' ;
KW_OBJECT : 'object' ;
KW_WHEN : 'when' ;
KW_THROW : 'throw' ;
KW_ABSTRACT : 'abstract' ;
KW_OPEN : 'open' ;
KW_VARARG : 'vararg' ;
KW_FILE : 'file' ;
KW_RECEIVER : 'receiver' ;
KW_PRIVATE : 'private' ;
KW_GET : 'get' ;
KW_PROTECTED : 'protected' ;
KW_OVERRIDE : 'override' ;
KW_INNER : 'inner' ;

SEMI
  : NEWLINE
  | ';'
  ;

// Differs from Kotlin grammar. Kotlin compiler allows use of keywords in some places.
// 19.07.2017: erased KW_ELSE because "if ("abc") "xtz" else "qwe"" was parsed incorrectly as infixCall.
//             also erased KW_WHEN for similar reasons in example "when (123) {}"
//             and KW_FUN
// 09.08.2017: Deleted all keywords (KW_REIFIED, KW_CLASS, ...), because another subtle bug with `infixCall` rule appeared.
// 18.08.2017: Added KW_FIELD, because it is essential in custom setters.
// 20.08.2017: Added KW_CLASS to allow expressions like "A::class".
// 21.08.2017: Added KW_GET and KW_SET because there are 200+ files with calls to such functions.
simpleName:
  SimpleName
  | KW_FIELD
  | KW_CLASS
  | KW_GET
  | KW_SET
  ;

SimpleName
  : Identifier
  // Differs from Kotlin grammar: allow more backticked values than just "Identifier".
  // Otherwise, it is harder to implement and I do not see any profit.
  | '`' .*? '`'
  ;

// Differs from Kotlin grammar: added 'L' suffix.
IntegerLiteral
  : Digit (Digit | '_')* 'L'?
  ;


fragment
NEWLINE : ('\n' | '\r\n')
  ;


WS : (' ' | '\t') -> channel(HIDDEN) ;

DecimalFloatingEndingDot: Digits '.' ;
DecimalFloatingStartingDot: '.' Digits ;

FloatLiteral : FloatingPointLiteral ;

HexadecimalLiteral
  : '0x' HexDigit (HexDigit | '_')*
  ;

CharacterLiteral : CharacterLiteral_ ;


shortTemplateEntryStart
  : '$'
  ;

EscapeSequence
  : UnicodeEscapeSequence | RegularEscapeSequence
  ;

UnicodeEscapeSequence
  : '\\u' HexDigit HexDigit HexDigit HexDigit
  ;

RegularEscapeSequence
  : '\\' ~[\r\n]
  ;


// triple-quoted strings taken from https://github.com/antlr/grammars-v4/blob/master/python3/Python3.g4
fragment LONG_STRING
 : '"""' LONG_STRING_ITEM*? '"""'
 ;

fragment LONG_STRING_ITEM
 : LONG_STRING_CHAR
 | STRING_ESCAPE_SEQ
 ;

fragment LONG_STRING_CHAR
 : ~'\\'
 ;

fragment STRING_ESCAPE_SEQ
 : '\\' .
 ;

// The rest copied mostly from https://github.com/antlr/grammars-v4/blob/master/java8/Java8.g4
fragment
CharacterLiteral_
	:	'\'' SingleCharacter '\''
	|	'\'' EscapeSequence_ '\''
	;

fragment
EscapeSequence_
	:	'\\' [btnfr"'\\]
    ;

fragment
SingleCharacter
	:	~['\\]
	;

fragment
FloatingPointLiteral
	:	DecimalFloatingPointLiteral
	|	HexadecimalFloatingPointLiteral
	;

fragment
DecimalFloatingPointLiteral
	:	Digits '.' Digits? ExponentPart? FloatTypeSuffix?
	|	'.' Digits ExponentPart? FloatTypeSuffix?
	|	Digits ExponentPart FloatTypeSuffix?
	|	Digits FloatTypeSuffix
	;



fragment
Digits
	:	Digit (DigitsAndUnderscores? Digit)?
	;

fragment
DigitsAndUnderscores
	:	DigitOrUnderscore+
	;

fragment
DigitOrUnderscore
	:	Digit
	|	'_'
	;

fragment
ExponentPart
	:	ExponentIndicator SignedInteger
	;

fragment
ExponentIndicator
	:	[eE]
	;

fragment
SignedInteger
	:	Sign? Digits
	;

fragment
Sign
	:	[+-]
	;

fragment
FloatTypeSuffix
	:	[fFdD]
	;

fragment
HexadecimalFloatingPointLiteral
	:	HexSignificand BinaryExponent FloatTypeSuffix?
	;

fragment
HexSignificand
	:	HexNumeral '.'?
	|	'0' [xX] HexDigits? '.' HexDigits
	;

fragment
BinaryExponent
	:	BinaryExponentIndicator SignedInteger
	;

fragment
BinaryExponentIndicator
	:	[pP]
	;

fragment
HexNumeral
	:	'0' [xX] HexDigits
	;

fragment
HexDigits
	:	HexDigit (HexDigitsAndUnderscores? HexDigit)?
	;

fragment
HexDigitsAndUnderscores
	:	HexDigitOrUnderscore+
	;

fragment
HexDigitOrUnderscore
	:	HexDigit
	|	'_'
	;

fragment
HexDigit
	:	[0-9a-fA-F]
	;

fragment
Digit: [0-9] ;

fragment
Identifier
	:	JavaLetter JavaLetterOrDigit*
	;

fragment
JavaLetter
	:	[a-zA-Z$_] // these are the 'java letters' below 0x7F
	;

fragment
JavaLetterOrDigit
	:	[a-zA-Z0-9$_] // these are the 'java letters or digits' below 0x7F
	;

// Differs from Kotlin grammar: dropped `@` because it is appended in other rules
// that use `labelName`
labelName
  : simpleName
  ;


COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;

fragment
RegularStringPart
  : ~[\\"$\r\n]
  ;
