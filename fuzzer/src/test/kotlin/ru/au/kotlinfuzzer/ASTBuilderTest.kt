package ru.au.kotlinfuzzer

import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite
import ru.au.kotlinfuzzer.ast.*
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.ast.builders.unitType
import ru.au.kotlinfuzzer.ast.entities.*
import ru.au.kotlinfuzzer.mutation.getTypedNode
import ru.au.kotlinfuzzer.util.getCompilerTestDataFullname
import ru.au.kotlinfuzzer.util.getMyTestDataFullname
import kotlin.test.*


@RunWith(Suite::class)
@Suite.SuiteClasses(
    BuilderSmokeTests::class,
    BuilderFeaturesTest::class
)
class ASTBuilderTestSuite {

}

class BuilderSmokeTests {

    @Test
    fun ASTisASTNode() {
        val ast = buildASTFromFile(getCompilerTestDataFullname("codegen/box/super/enclosedFun.kt"))
        assertTrue(ast is ASTNode)
    }

    @Test
    fun noExceptionsOnUnknownFile() {
        // Assume that not all features from the file are supported
        val ast = buildASTFromFile(getCompilerTestDataFullname("codegen/box/super/traitproperty.kt"))
        assertTrue(ast is ASTNode)
    }
}


class BuilderFeaturesTest {
    @Test
    fun parsePreamble() {
        val ast = buildASTFromFile(getMyTestDataFullname("preamble.kt"))

        val childrenList = ast.membersTyped.children

        assertEquals(5, childrenList.size)

        assertTrue(childrenList[0] is PackageNode)
        assertEquals("a.b.c", (childrenList[0] as PackageNode).name)

        assertTrue(childrenList[1] is ImportNode)
        assertEquals("x.y.z.j", (childrenList[1] as ImportNode).name)
        assertNull((childrenList[1] as ImportNode).alias)

        assertTrue(childrenList[2] is ImportNode)
        assertEquals("a", (childrenList[2] as ImportNode).name)
        assertNull((childrenList[2] as ImportNode).alias)

        assertTrue(childrenList[3] is ImportNode)
        assertEquals("all", (childrenList[3] as ImportNode).name)
        assertNull((childrenList[3] as ImportNode).alias)

        assertTrue(childrenList[4] is ImportNode)
        assertEquals("abc.io", (childrenList[4] as ImportNode).name)
        assertEquals("cool", (childrenList[4] as ImportNode).alias)
    }

    @Test
    fun parseFunctionHeadersWithoutTypes() {
        val ast = buildASTFromFile(getMyTestDataFullname("functions_simple.kt"))

        val childrenList = ast.membersTyped.children

        assertEquals(4, childrenList.size)

        val funcTyped = childrenList[0] as FunctionDeclarationNode
        assertEquals("func_typed", funcTyped.name)
        assertNull(funcTyped.receiverType)
        assertEquals(0, funcTyped.arguments.size)

        val funcBlock = childrenList[1] as FunctionDeclarationNode
        assertEquals("func_block", funcBlock.name)
        assertNull(funcBlock.receiverType)
        assertEquals(0, funcBlock.arguments.size)

        val funcArgs = childrenList[2] as FunctionDeclarationNode
        assertEquals("func_args", funcArgs.name)
        assertNull(funcArgs.receiverType)
        assertEquals(2, funcArgs.arguments.size)
        assertEquals("x", funcArgs.argumentsTyped[0].varDeclTyped.name)
        assertEquals("y", funcArgs.argumentsTyped[1].varDeclTyped.name)

        val funcReceiver = childrenList[3] as FunctionDeclarationNode
        assertEquals("func_receiver", funcReceiver.name)
        assertNotNull(funcReceiver.receiverType)
        assertEquals(0, funcReceiver.arguments.size)
    }

    @Test
    fun parseFunctionHeadersWithTypes() {
        val ast = buildASTFromFile(getMyTestDataFullname("functions_medium.kt"))
        val stringType = SimpleType("String")
        val intType = SimpleType("Int")

        val childrenList = ast.membersTyped.children

        val funcNullable = childrenList[0] as FunctionDeclarationNode
        assertEquals("f1", funcNullable.name)
        assertEquals(0, funcNullable.arguments.size)
        assertTrue(funcNullable.returnType is NullableType)
        assertEquals(NullableType(stringType), funcNullable.returnType)

        val funcReceiverAndArgs = childrenList[1] as FunctionDeclarationNode
        assertEquals("f2", funcReceiverAndArgs.name)
        assertEquals(intType, funcReceiverAndArgs.receiverType)
        assertTrue(funcReceiverAndArgs.returnType is DynamicType)
        val args = funcReceiverAndArgs.arguments
        assertEquals(FunctionArgument(VariableDeclaration("x", unitType), null), args[0])
        assertEquals(FunctionArgument(VariableDeclaration("y", SimpleType("Nothing")), null), args[1])

        val funcFunctionReceiver = childrenList[2] as FunctionDeclarationNode
        assertEquals("f3", funcFunctionReceiver.name)
        assertEquals(unitType, funcFunctionReceiver.returnType)
        assertTrue(funcFunctionReceiver.receiverType is FunctionType)
        val recType = funcFunctionReceiver.receiverType as FunctionType
        assertNull(recType.receiverType)
        assertEquals(2, recType.params.size)
        assertEquals(stringType, recType.returnType)
        val recTypeParam0 = recType.params[0] as FunctionTypeParameter
        assertEquals(DottedType(lhs=DottedType(lhs=SimpleType(name="a"), rhs=SimpleType(name="b")), rhs=SimpleType(name="Double")), recTypeParam0.type)
        val secondParamType = (recType.params[1] as FunctionTypeParameter).type as FunctionType
        assertEquals(unitType, secondParamType.returnType)
        assertEquals(1, secondParamType.params.size)
        assertEquals(stringType, (secondParamType.params[0] as FunctionTypeParameter).type)
        assertEquals(intType, secondParamType.receiverType)
        val funcRetFunc = childrenList[3] as FunctionDeclarationNode
        assertEquals("f4", funcRetFunc.name)
        assertTrue(funcRetFunc.argumentsTyped[0].varDeclTyped.type is DynamicType)
        assertEquals("x", funcRetFunc.argumentsTyped[0].varDeclTyped.name)
        assertTrue(funcRetFunc.returnType is FunctionType)
        assertEquals(intType, (funcRetFunc.returnType as FunctionType).paramsTyped[0].type)
        assertEquals(SimpleType("Long"), (funcRetFunc.returnType as FunctionType).returnType)

        val funcNamedFunctype = childrenList[4] as FunctionDeclarationNode
        val funcNamedFunctypeArgs = funcNamedFunctype.argumentsTyped
        assertEquals("f5", funcNamedFunctype.name)
        assertTrue(funcNamedFunctypeArgs[0].varDeclTyped.type is FunctionType)
        assertEquals("name", funcNamedFunctypeArgs[0].varDeclTyped.name)
        val namedParams = (funcNamedFunctypeArgs[0].varDeclTyped.type as FunctionType).paramsTyped
        assertEquals("p1", namedParams[0].name)
        assertEquals(intType, namedParams[0].type)
        assertNull(namedParams[1].name)
        assertEquals(unitType, namedParams[1].type)
        assertEquals("p3", namedParams[2].name)
        assertEquals(intType, namedParams[2].type)
        assertEquals(SimpleType("Byte"), (funcNamedFunctypeArgs[0].varDeclTyped.type as FunctionType).returnType)

        val funcReceiverNull = childrenList[5] as FunctionDeclarationNode
        assertEquals("f6", funcReceiverNull.name)
        assertEquals(NullableType(unitType), funcReceiverNull.receiverType)

        val funcArgNoRetFunctype = childrenList[6] as FunctionDeclarationNode
        assertEquals("f7", funcArgNoRetFunctype.name)
        val funArgNoRetArguments = funcArgNoRetFunctype.argumentsTyped
        assertTrue(funArgNoRetArguments[0].varDeclTyped.type is FunctionType)
        val noRetFuntype = funArgNoRetArguments[0].varDeclTyped.type as FunctionType
        assertEquals(unitType, noRetFuntype.returnType)
        assertEquals(intType, noRetFuntype.paramsTyped[0].type)
    }

    @Test
    fun parseAtomicExpressions() {
        val ast = buildASTFromFile(getMyTestDataFullname("atomic_expression.kt"))

        val childrenList = ast.membersTyped.children

        val expressions = childrenList.map {
            (it as FunctionDeclarationNode).body as ExpressionNode
        }

        assertTrue(expressions[0] is ParenthizedExpressionNode)
        for (i in 1..9) {
            assertTrue(expressions[i] is LiteralConstantNode)
        }

        assertTrue(expressions[10] is ThisNode)
        assertTrue(expressions[11] is ThisNode)

        assertTrue(expressions[12] is SuperNode)
        assertTrue(expressions[13] is SuperNode)
        assertTrue(expressions[14] is SuperNode)

        assertTrue(expressions[15] is IfNode)
        assertTrue(expressions[16] is IfNode)

        assertTrue(expressions[17] is WhenNode)
        assertTrue(expressions[18] is WhenNode)

        assertTrue(expressions[19] is TryNode)

        assertTrue(expressions[20] is ObjectLiteralNode)

        assertTrue(expressions[21] is ThrowNode)

        assertTrue(expressions[22] is ReturnNode)
        assertTrue(expressions[23] is ReturnNode)

        assertTrue(expressions[24] is LoopJumpNode)
        assertTrue(expressions[25] is LoopJumpNode)

        assertTrue(expressions[26] is ForLoopNode)
        assertTrue(expressions[27] is WhileLoopNode)
        assertTrue(expressions[28] is WhileLoopNode)

        assertTrue(expressions[29] is VariableUsageNode)

        assertTrue(expressions[30] is FunctionLiteralNode)

        assertTrue(expressions[31] is ForLoopNode)

        assertTrue(expressions[32] is FunctionLiteralNode)
        assertTrue(expressions[33] is FunctionLiteralNode)
    }

    @Test
    fun parseDeclarationHeaders() {
        val ast = buildASTFromFile(getMyTestDataFullname("declaration_simple.kt"))

        val topLevel = ast.membersTyped.children
        assertTrue(topLevel[0] is FunctionDeclarationNode)
        val funBody = (topLevel[0] as FunctionDeclarationNode).body
        assertTrue(funBody is StatementsNode)

        val statements = (funBody as StatementsNode).children

        assertTrue(statements[0] is FunctionDeclarationNode)

        assertTrue(statements[1] is PropertyDeclarationNode)
        val statement1Typed = statements[1] as PropertyDeclarationNode
        assertEquals(PropertyType.VAL, statement1Typed.propType)
        val varDeclStatement1 = statement1Typed.varDeclTyped[0]
        assertEquals(SimpleType("String"), varDeclStatement1.type)
        assertEquals("prop", varDeclStatement1.name)

        assertTrue(statements[2] is PropertyDeclarationNode)
        val statements2Casted = statements[2] as PropertyDeclarationNode
        assertEquals(PropertyType.VAL, statements2Casted.propType)
        val varDeclStatement2 = statements2Casted.varDeclTyped[0]
        assertEquals(unitType, varDeclStatement2.type)
        assertEquals("prop_2", varDeclStatement2.name)

        assertTrue(statements[3] is PropertyDeclarationNode)
        val statements3Casted = statements[3] as PropertyDeclarationNode
        assertEquals(PropertyType.VAR, statements3Casted.propType)
        assertEquals(3, statements3Casted.varDecl.size)

        assertTrue(statements[4] is PropertyDeclarationNode)
        val statements4Casted = statements[4] as PropertyDeclarationNode
        assertEquals(PropertyType.VAL, statements4Casted.propType)
        val varDeclStatement4 = statements4Casted.varDeclTyped[0]
        assertEquals(SimpleType("Int"), varDeclStatement4.type)
        assertEquals("t", varDeclStatement4.name)

        assertTrue(statements[5] is ClassDeclarationNode)
        val statements5Casted = statements[5] as ClassDeclarationNode
        assertEquals("A", statements5Casted.name)
        assertEquals(ClassNodeType.CLASS, statements5Casted.nodeType)

        assertTrue(statements[6] is ClassDeclarationNode)
        val statements6Casted = statements[6] as ClassDeclarationNode
        assertEquals("B", statements6Casted.name)
        assertEquals(ClassNodeType.INTERFACE, statements6Casted.nodeType)

        assertTrue(statements[7] is TypealiasNode)
        val statements7Casted = statements[7] as TypealiasNode
        assertEquals("bla", statements7Casted.name)
        assertEquals(SimpleType("Int"), statements7Casted.type)

        assertTrue(statements[8] is ObjectNode)
        assertEquals("x", (statements[8] as ObjectNode).name)
    }

    @Ignore // operator precedence is broken right now
    @Test
    fun testBinaryOperations() {
        val ast = buildASTFromFile(getMyTestDataFullname("binary_ops.kt"))

        val topLevel = ast.membersTyped.children

        val equals3 = topLevel[0] as FunctionDeclarationNode
        val eq3body = equals3.body as BinaryOpNode
        assertEquals(BinaryOpType.OR, eq3body.type)
        assertEquals(BinaryOpType.GE, (eq3body.right as BinaryOpNode).type)
        assertEquals(BinaryOpType.AND, (eq3body.left as BinaryOpNode).type)
        assertEquals(BinaryOpType.NOT_EQ, ((eq3body.left as BinaryOpNode).left as BinaryOpNode).type)
        assertEquals(BinaryOpType.AND, ((eq3body.left as BinaryOpNode).right as BinaryOpNode).type)
        assertEquals(BinaryOpType.EQ, (((eq3body.left as BinaryOpNode).right as BinaryOpNode).right as BinaryOpNode).type)
    }

    @Test
    fun testCalls() {
        val ast = buildASTFromFile(getMyTestDataFullname("calls.kt"))

        val topLevel = ast.membersTyped.children

        val infixCall = topLevel[0] as FunctionDeclarationNode
        val infixCallBody = infixCall.body as InfixCallNode
        assertEquals("xor", infixCallBody.funcName)
        assertEquals(LiteralConstantNode("1"), infixCallBody.argLeft)
        assertEquals(LiteralConstantNode("2"), infixCallBody.argRight)
    }

    @Test
    fun testUnaryPrefixOps() {
        val ast = buildASTFromFile(getMyTestDataFullname("unary_ops.kt"))

        val prefixOps = (getTypedNode<FunctionDeclarationNode>(ast.membersTyped.children[0]).body as StatementsNode).children

        assertEquals(5, prefixOps.size)
        for (op in prefixOps) {
            assertTrue(op is FunctionDeclarationNode)
            assertTrue(getTypedNode<FunctionDeclarationNode>(op).body is PrefixUnaryOpNode)
        }

        val prefixOpsTyped = prefixOps.map {
            getTypedNode<PrefixUnaryOpNode>(getTypedNode<FunctionDeclarationNode>(it).body!!)
        }
        assertEquals(PrefixUnaryOpType.NEG, prefixOpsTyped[0].type)
        assertTrue(prefixOpsTyped[0].expr is LiteralConstantNode)

        assertEquals(PrefixUnaryOpType.LABEL, prefixOpsTyped[1].type)
        assertNotNull(prefixOpsTyped[1].labelName)
        assertEquals(PrefixUnaryOpType.INCREMENT,
                getTypedNode<PrefixUnaryOpNode>(prefixOpsTyped[1].expr).type)
        assertEquals(PrefixUnaryOpType.NOT,
                getTypedNode<PrefixUnaryOpNode>(getTypedNode<PrefixUnaryOpNode>(prefixOpsTyped[1].expr).expr).type)

        assertEquals(PrefixUnaryOpType.ANNOTATION, prefixOpsTyped[2].type)
        assertNotNull(prefixOpsTyped[2].annotations)

        assertEquals(PrefixUnaryOpType.ANNOTATION, prefixOpsTyped[3].type)
        assertEquals(PrefixUnaryOpType.POS, getTypedNode<PrefixUnaryOpNode>(prefixOpsTyped[3].expr).type)
        assertNotNull(prefixOpsTyped[3].annotations)

        assertEquals(PrefixUnaryOpType.DECREMENT, prefixOpsTyped[4].type)
    }

    @Test
    fun testUnaryPostfixOps() {
        val ast = buildASTFromFile(getMyTestDataFullname("unary_ops.kt"))

        val postfixOps = getTypedNode<StatementsNode>(getTypedNode<FunctionDeclarationNode>(ast.membersTyped.children[1]).body!!).children.map {
            (it as FunctionDeclarationNode).body as ExpressionNode
        }

        for (i in 0..2) {
            assertTrue(postfixOps[i] is CallableReferenceNode)
        }

        assertEquals(PostfixUnaryOpType.INCREMENT, getTypedNode<PostfixUnaryNode>(postfixOps[3]).type)
        assertEquals(PostfixUnaryOpType.DECREMENT, getTypedNode<PostfixUnaryNode>(postfixOps[4]).type)
        assertEquals(PostfixUnaryOpType.NOT_NULL, getTypedNode<PostfixUnaryNode>(postfixOps[5]).type)

        val lambdaChain = getTypedNode<MemberAccessNode>(postfixOps[6])
        assertEquals(MemberAccessType.SAFE, lambdaChain.type)
        assertEquals(VariableUsageNode("a"), lambdaChain.obj)
        val mapMember = getTypedNode<MemberAccessNode>(lambdaChain.member)
        assertEquals(MemberAccessType.DOT, mapMember.type)
        val mapCall = getTypedNode<FunctionCallNode>(mapMember.obj)
        assertEquals(VariableUsageNode("map"), mapCall.func)
        assertEquals(1, mapCall.typeArgs.size)
        assertEquals(1, mapCall.args.size)
        assertTrue(mapCall.args[0] is FunctionLiteralNode)
        val filterCall = getTypedNode<FunctionCallNode>(mapMember.member)
        assertEquals(VariableUsageNode("filter"), filterCall.func)
        assertEquals(0, filterCall.typeArgs.size)
        assertEquals(1, filterCall.args.size)


        val callChain = getTypedNode<FunctionCallNode>(postfixOps[7])
        assertEquals(3, callChain.args.size)
        assertTrue(callChain.argsTypedVA[1].needUnpack)
        assertFalse(callChain.argsTypedVA[0].needUnpack)
        assertFalse(callChain.argsTypedVA[2].needUnpack)
        assertNull(callChain.argsTypedVA[0].name)
        assertNull(callChain.argsTypedVA[1].name)
        assertEquals("x", callChain.argsTypedVA[2].name)
        assertEquals(2, callChain.typeArgs.size)
        assertEquals(VariableUsageNode("bar"), getTypedNode<FunctionCallNode>(callChain.func).func)

        val arrSub = getTypedNode<ArrayAccessNode>(postfixOps[8])
        assertEquals(1, arrSub.expressions.size)
        val innerArr = getTypedNode<ArrayAccessNode>(arrSub.arr)
        assertEquals(3, innerArr.expressions.size)
        assertTrue(innerArr.arr is CallableReferenceNode)
    }

    @Test
    fun parseGenericTypes() {
        val ast = buildASTFromFile(getMyTestDataFullname("generic_types.kt"))

        val topLevel = ast.membersTyped.children

        val func = getTypedNode<FunctionDeclarationNode>(topLevel[0])
        val funcGenericParams = getTypedNode<GenericTypeParams>(func.genericParams!!)
        assertEquals(2, funcGenericParams.types.size)
        assertEquals(SimpleType("T"), funcGenericParams.types[0])
        assertEquals(SimpleType("R"), getTypedNode<TypeProjection>(funcGenericParams.types[1]).type)
        assertEquals(listOf("reified", "in"), getTypedNode<TypeProjection>(funcGenericParams.types[1]).modifiersTyped.rawModifiersAnnotations)

        val funcReceiverType = getTypedNode<DottedType>(func.receiverType!!)
        assertEquals(SimpleType("List"), getTypedNode<ProjectedGenericType>(funcReceiverType.rhs).innerType)
        assertEquals(SimpleType("T"), getTypedNode<ProjectedGenericType>(funcReceiverType.rhs).projectionsTyped[0].type)
        assertEquals(0, getTypedNode<ProjectedGenericType>(funcReceiverType.rhs).projectionsTyped[0].modifiersTyped.rawModifiersAnnotations.size)
        assertEquals(1, getTypedNode<ProjectedGenericType>(funcReceiverType.rhs).projectionsTyped.size)
        val funcRecTypeLhs = getTypedNode<DottedType>(funcReceiverType.lhs)
        assertEquals(SimpleType("b"), getTypedNode<ProjectedGenericType>(funcRecTypeLhs.rhs).innerType)
        assertEquals(listOf("*"), getTypedNode<ProjectedGenericType>(funcRecTypeLhs.rhs).projectionsTyped[0].modifiersTyped.rawModifiersAnnotations)
        assertNull(getTypedNode<ProjectedGenericType>(funcRecTypeLhs.rhs).projectionsTyped[0].type)
        assertEquals(1, getTypedNode<ProjectedGenericType>(funcRecTypeLhs.rhs).projectionsTyped.size)
        val funcRecTypeLhsLhs = getTypedNode<DottedType>(funcRecTypeLhs.lhs)
        assertEquals(2, getTypedNode<ProjectedGenericType>(funcRecTypeLhsLhs.rhs).projectionsTyped.size)
        assertEquals(SimpleType("lang"), getTypedNode<ProjectedGenericType>(funcRecTypeLhsLhs.rhs).innerType)
        assertEquals(listOf("in"), getTypedNode<ProjectedGenericType>(funcRecTypeLhsLhs.rhs).projectionsTyped[0].modifiersTyped.rawModifiersAnnotations)
        assertEquals(SimpleType("R"), getTypedNode<ProjectedGenericType>(funcRecTypeLhsLhs.rhs).projectionsTyped[0].type)
        assertEquals(listOf("out"), getTypedNode<ProjectedGenericType>(funcRecTypeLhsLhs.rhs).projectionsTyped[1].modifiersTyped.rawModifiersAnnotations)
        assertEquals(SimpleType("U"), getTypedNode<ProjectedGenericType>(funcRecTypeLhsLhs.rhs).projectionsTyped[1].type)
        assertEquals(SimpleType("java"), funcRecTypeLhsLhs.lhs)

        val cls = getTypedNode<ClassDeclarationNode>(topLevel[1])
        assertEquals(2, getTypedNode<GenericTypeParams>(cls.typeParams!!).types.size)
        assertEquals(listOf("out"), getTypedNode<TypeProjection>(getTypedNode<GenericTypeParams>(cls.typeParams!!).types[0]).modifiersTyped.rawModifiersAnnotations)
        assertEquals(SimpleType("R"), getTypedNode<TypeProjection>(getTypedNode<GenericTypeParams>(cls.typeParams!!).types[0]).type)
        assertEquals(listOf("in"), getTypedNode<TypeProjection>(getTypedNode<GenericTypeParams>(cls.typeParams!!).types[1]).modifiersTyped.rawModifiersAnnotations)
        assertEquals(SimpleType("D"), getTypedNode<TypeProjection>(getTypedNode<GenericTypeParams>(cls.typeParams!!).types[1]).type)

        val alias = getTypedNode<TypealiasNode>(topLevel[2])
        assertEquals(1, getTypedNode<GenericTypeParams>(alias.genericParams!!).types.size)
        assertEquals(SimpleType("T"), getTypedNode<GenericTypeParams>(alias.genericParams!!).types[0])

        val prop = getTypedNode<PropertyDeclarationNode>(topLevel[3])
        assertEquals(1, getTypedNode<GenericTypeParams>(prop.genericParams!!).types.size)
        assertEquals(SimpleType("T"), getTypedNode<GenericTypeParams>(prop.genericParams!!).types[0])
    }
}