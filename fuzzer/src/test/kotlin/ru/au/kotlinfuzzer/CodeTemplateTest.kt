package ru.au.kotlinfuzzer

import org.junit.Test
import ru.au.kotlinfuzzer.ast.*
import ru.au.kotlinfuzzer.ast.entities.*
import ru.au.kotlinfuzzer.fuzzing.FuzzingFriendlyNode
import ru.au.kotlinfuzzer.fuzzing.invokeKotlinc
import ru.au.kotlinfuzzer.fuzzing.makeFuzzingUnfriendly
import ru.au.kotlinfuzzer.mutation.*
import ru.au.kotlinfuzzer.util.getMyTestDataFullname
import kotlin.test.*

class CodeTemplateTest {
    private fun checkChangeNullability(nullabilityChanger: MutationTemplate, appliedCheckNeedToBeFalse: Boolean): FuzzingFriendlyNode {
        val ffast = buildFuzzingFriendlyASTFromFile(getMyTestDataFullname("nullability.kt"))

        assertTrue(ffast.node is KotlinFileNode)
        assertFalse(nullabilityChanger.canBeApplied(ffast))

        val topLevel = getTypedNode<KotlinFileNode>(ffast).membersTyped.children

        val foo = getTypedNode<FunctionDeclarationNode>(topLevel[0])
        assertFalse(nullabilityChanger.canBeApplied(topLevel[0] as FuzzingFriendlyNode))
        val fooType = foo.returnType as FuzzingFriendlyNode
        assertTrue(nullabilityChanger.canBeApplied(fooType) xor appliedCheckNeedToBeFalse)

        val bar = getTypedNode<FunctionDeclarationNode>(topLevel[1])
        assertFalse(nullabilityChanger.canBeApplied(topLevel[1] as FuzzingFriendlyNode))
        val barType = bar.returnType as FuzzingFriendlyNode
        assertFalse(nullabilityChanger.canBeApplied(barType) xor appliedCheckNeedToBeFalse)
        val barInnerType = (barType.node as NullableType).innerType as FuzzingFriendlyNode
        assertFalse(nullabilityChanger.canBeApplied(barInnerType))

        val goo = getTypedNode<FunctionDeclarationNode>(topLevel[2])
        val gooBody = getTypedNode<CallableReferenceNode>(goo.body!!)
        assertFalse(nullabilityChanger.canBeApplied(gooBody.type as FuzzingFriendlyNode))

        return if (appliedCheckNeedToBeFalse) barType else fooType
    }

    @Test
    fun testAddNullability() {
        val nullabilityChanger = AddNullability()
        val needToBeChangedNode = checkChangeNullability(nullabilityChanger, false)
        nullabilityChanger.apply(needToBeChangedNode)
        assertTrue(needToBeChangedNode.node is NullableType)
        assertTrue((needToBeChangedNode.node as NullableType).innerType is FuzzingFriendlyNode)
        assertTrue(((needToBeChangedNode.node as NullableType).innerType as FuzzingFriendlyNode).node is KotlinType)
    }

    @Test
    fun testDeleteNullability() {
        val nullabilityChanger = DeleteNullability()
        val needToBeChangedNode = checkChangeNullability(nullabilityChanger, true)
        nullabilityChanger.apply(needToBeChangedNode)
        assertEquals(SimpleType("Int"), needToBeChangedNode.node)
    }

    @Test
    fun testAddFunctionModifiers() {
        val filename = getMyTestDataFullname("modifiers.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val modifierAdder = AddFunctionModifier()
        val topLevel = getTypedNode<KotlinFileNode>(ffast).membersTyped.children

        val cls = getTypedNode<ClassDeclarationNode>(topLevel[0])
        val clsModifiers = cls.modifiers
        assertFalse(modifierAdder.canBeApplied(clsModifiers as FuzzingFriendlyNode))

        val foo = getTypedNode<FunctionDeclarationNode>(topLevel[1])
        val fooModifiers = foo.modifiers
        assertTrue(modifierAdder.canBeApplied(fooModifiers as FuzzingFriendlyNode))
        modifierAdder.apply(fooModifiers)
        assertEquals(4, getTypedNode<ModifiersNode>(foo.modifiers).rawModifiersAnnotations.size)

        val bar = topLevel[2]
        val barModifiers = getTypedNode<FunctionDeclarationNode>(bar).modifiers
        assertTrue(modifierAdder.canBeApplied(barModifiers as FuzzingFriendlyNode))
    }

    @Test
    fun testAddClassModifiers() {
        val filename = getMyTestDataFullname("modifiers.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val modifierAdder = AddClassModifier()
        val topLevel = getTypedNode<KotlinFileNode>(ffast).membersTyped.children

        val cls = getTypedNode<ClassDeclarationNode>(topLevel[0])
        val clsModifiers = cls.modifiers
        assertTrue(modifierAdder.canBeApplied(clsModifiers as FuzzingFriendlyNode))
        assertEquals(1, cls.modifiersTyped.rawModifiersAnnotations.size)
        modifierAdder.apply(clsModifiers)
        assertEquals(2, getTypedNode<ModifiersNode>(cls.modifiers).rawModifiersAnnotations.size)

        val foo = getTypedNode<FunctionDeclarationNode>(topLevel[1])
        val fooModifiers = foo.modifiers
        assertFalse(modifierAdder.canBeApplied(fooModifiers as FuzzingFriendlyNode))
    }

    @Test
    fun testRenameVariable() {
        val filename = getMyTestDataFullname("scope_simple.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val renamer = RenameVariable()

        assertFalse(renamer.canBeApplied(ffast))

        val topLevel = getTypedNode<KotlinFileNode>(ffast).membersTyped.children

        assertFalse(renamer.canBeApplied(topLevel[0] as FuzzingFriendlyNode))

        val secondFunc = getTypedNode<FunctionDeclarationNode>(topLevel[1])
        val argDecl = secondFunc.argumentsTyped.single().varDecl as FuzzingFriendlyNode
        assertTrue(renamer.canBeApplied(argDecl))

        var renamedSuccess = false
        1.rangeTo(5000).forEach {
            renamer.apply(argDecl)
            val argName = (argDecl.node as VariableDeclaration).name
            renamedSuccess = renamedSuccess || (argName == "second" || argName == "first")
        }

        if (!renamedSuccess) {
            fail()
        }

        val funBody = getTypedNode<StatementsNode>(secondFunc.body!!)
        val ifStmt = getTypedNode<IfNode>(getTypedNode<BlockExpressionNode>(funBody.children[0]).expr)
        val ifExpr = ifStmt.condExpr as FuzzingFriendlyNode
        assertTrue(renamer.canBeApplied(ifExpr))

        renamedSuccess = false
        1.rangeTo(5000).forEach {
            renamer.apply(ifExpr)
            val argName = (ifExpr.node as VariableUsageNode).name
            renamedSuccess = renamedSuccess || (argName == "second" || argName == "first")
        }
        if (!renamedSuccess) {
            fail()
        }
    }

    @Test
    fun testAddFuncReceiver() {
        val filename = getMyTestDataFullname("func_add_receiver.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val mutator = AddFunctionReceiver()

        assertFalse(mutator.canBeApplied(getTypedNode<KotlinFileNode>(ffast).membersTyped.children[0] as FuzzingFriendlyNode))
        assertFalse(mutator.canBeApplied(getTypedNode<KotlinFileNode>(ffast).membersTyped.children[1] as FuzzingFriendlyNode))

        val foo = getTypedNode<KotlinFileNode>(ffast).membersTyped.children[2]
        assertTrue(mutator.canBeApplied(foo as FuzzingFriendlyNode))
        mutator.apply(foo)
        assertNotNull(((foo.node as FunctionDeclarationNode).receiverType as FuzzingFriendlyNode).node)

        val bar = getTypedNode<KotlinFileNode>(ffast).membersTyped.children[3]
        assertFalse(mutator.canBeApplied(bar as FuzzingFriendlyNode))
    }

    @Test
    fun testAddPropReceiver() {
        val filename = getMyTestDataFullname("prop_add_receiver.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val mutator = AddPropertyReceiver()

        val t = getTypedNode<KotlinFileNode>(ffast).membersTyped.children[0]
        assertTrue(mutator.canBeApplied(t as FuzzingFriendlyNode))
        mutator.apply(t)
        assertNotNull(((t.node as PropertyDeclarationNode).receiverType as FuzzingFriendlyNode).node)

        val x = getTypedNode<KotlinFileNode>(ffast).membersTyped.children[1]
        assertFalse(mutator.canBeApplied(x as FuzzingFriendlyNode))
    }

    @Test
    fun testAddNonnullAssertion() {
        val filename = getMyTestDataFullname("binary_ops.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val mutator = AddNonnullAssertion()

        val topLevel = getTypedNode<KotlinFileNode>(ffast).membersTyped.children

        assertFalse(mutator.canBeApplied(topLevel[0] as FuzzingFriendlyNode))

        val equals3Body = getTypedNode<FunctionDeclarationNode>(topLevel[0]).body
        assertFalse(mutator.canBeApplied(equals3Body as FuzzingFriendlyNode))
        val equals3BodyInner = getTypedNode<BinaryOpNode>(equals3Body).right
        assertTrue(mutator.canBeApplied(equals3BodyInner as FuzzingFriendlyNode))
        mutator.apply(equals3BodyInner)
        assertEquals(PostfixUnaryOpType.NOT_NULL, getTypedNode<PostfixUnaryNode>(equals3BodyInner).type)
        assertFalse(mutator.canBeApplied(equals3BodyInner))

        assertTrue(getTextFromAST(makeFuzzingUnfriendly(ffast)!!).contains("b)!!"))
    }

    @Test
    fun testReplaceExprs() {
        val filename = getMyTestDataFullname("replace_exprs.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val mutators = listOf(
                Triple(ReplaceExprWithTry(), "try {\n1", "try {\na"),
                Triple(ReplaceExprWithIf(), ") {\n(1)\n}", ") {\n(a)\n}"),
                Triple(ReplaceExprWithWhen(), "!= null -> (1)", "!= null -> (a)"),
                Triple(ReplaceExprWithRandomExpr(), "", ""),
                Triple(ReplaceExprWithElvis(), "1) ?: (1", "a) ?: (a")
        )
        val topLevel = getTypedNode<KotlinFileNode>(ffast).membersTyped.children

        for ((mutator, expectedFirstOutcome, expectedSecondOutcome) in mutators) {
            val fooBody = getTypedNode<FunctionDeclarationNode>(topLevel[0]).body!!
            val fooBodyLeft = getTypedNode<BinaryOpNode>(fooBody).left
            assertFalse(mutator.canBeApplied(fooBody as FuzzingFriendlyNode))
            assertTrue(mutator.canBeApplied(fooBodyLeft as FuzzingFriendlyNode))
            mutator.apply(fooBodyLeft)

            val barBody = getTypedNode<FunctionDeclarationNode>(topLevel[1]).body!!
            val barBodyLeft = getTypedNode<MemberAccessNode>(barBody).obj
            assertFalse(mutator.canBeApplied(barBody as FuzzingFriendlyNode))
            assertTrue(mutator.canBeApplied(barBodyLeft as FuzzingFriendlyNode))
            mutator.apply(barBodyLeft)

            val rewritten = getTextFromAST(makeFuzzingUnfriendly(ffast)!!)
            assertTrue(rewritten.contains(expectedFirstOutcome), rewritten)
            assertTrue(rewritten.contains(expectedSecondOutcome), rewritten)

            val tempFile = createTempFile(suffix=".kt")
            tempFile.writeText(rewritten)
            try {
                val invocationResult = invokeKotlinc(tempFile, true)
                if (mutator !is ReplaceExprWithRandomExpr
                        && mutator !is ReplaceExprWithIf) {
                    assertFalse(invocationResult.hasCompilationError(), rewritten + "\n" + invocationResult.combinedOutput)
                }
            } finally {
                tempFile.delete()
            }

            ffast.rollbackToOriginal()
        }
    }

    @Test
    fun addReifiedToGeneric() {
        val filename = getMyTestDataFullname("generic_types.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val func = getTypedNode<KotlinFileNode>(ffast.node!!).membersTyped.children[0] as FuzzingFriendlyNode
        val mutator = AddReifiedToGeneric()
        val inlineAdder = AddFunctionModifier()

        val funcModifiers = getTypedNode<FunctionDeclarationNode>(func).modifiers as FuzzingFriendlyNode
        while (inlineAdder.canBeApplied(funcModifiers))
            inlineAdder.apply(funcModifiers)

        assertTrue(mutator.canBeApplied(func))
        mutator.apply(func)
        assertFalse(mutator.canBeApplied(func))
    }

    @Test
    fun addVarianceAnnotation() {
        val filename = getMyTestDataFullname("generic_types.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val mutator = AddVarianceAnnotationToProjection()

        val func = getTypedNode<KotlinFileNode>(ffast.node!!).membersTyped.children[0] as FuzzingFriendlyNode
        val funcReceiver = getTypedNode<DottedType>(getTypedNode<FunctionDeclarationNode>(func).receiverType!!)

        val rhs = funcReceiver.rhs as FuzzingFriendlyNode
        assertFalse(mutator.canBeApplied(rhs))
        val rhsProj = getTypedNode<TypeProjection>(getTypedNode<ProjectedGenericType>(rhs).projections[0]).modifiers as FuzzingFriendlyNode
        assertTrue(mutator.canBeApplied(rhsProj))
        mutator.apply(rhsProj)
        assertTrue(mutator.canBeApplied(rhsProj))
        mutator.apply(rhsProj)
        assertFalse(mutator.canBeApplied(rhsProj))
    }
}