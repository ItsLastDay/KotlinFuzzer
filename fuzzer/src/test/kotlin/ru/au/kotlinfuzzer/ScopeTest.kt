package ru.au.kotlinfuzzer

import org.junit.Test
import ru.au.kotlinfuzzer.ast.*
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.ast.entities.SimpleType
import ru.au.kotlinfuzzer.ast.entities.VariableDeclaration
import ru.au.kotlinfuzzer.scope.Scope
import ru.au.kotlinfuzzer.util.getMyTestDataFullname
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ScopeTest {
    @Test
    fun testScopeStdlibTypes() {
        val ast = buildASTFromFile(getMyTestDataFullname("scope_simple.kt"))
        assertTrue(ast.scope!!.types.contains(SimpleType("Any")))
    }

    @Test
    fun testScopeTwoEntities() {
        val ast = buildASTFromFile(getMyTestDataFullname("scope_simple.kt"))

        assertEquals(Scope.EMPTY_SCOPE, ast.scope)
        val topLevel = ast.children.single().children

        assertNotNull(topLevel[0].scope)
        assertEquals(2, topLevel[0].scope!!.allEntities.size)
        val topLevelCasted = listOf(topLevel[0] as NamedDeclaration,
                topLevel[1])
        assertEquals(topLevelCasted, topLevel[0].scope!!.allEntities)

        assertNotNull(topLevel[1].scope)
        assertEquals(2, topLevel[1].scope!!.allEntities.size)
        assertEquals(topLevelCasted, topLevel[1].scope!!.allEntities)
    }

    @Test
    fun testScopeManyEntities() {
        val ast = buildASTFromFile(getMyTestDataFullname("scope_many_entities.kt"))

        val topLevel = ast.children.single().children
        val testFun = topLevel[4] as FunctionDeclarationNode

        val testFunArg = VariableDeclaration("arg", SimpleType("Int"))
        val topLevelScope = listOf(topLevel[0], topLevel[1], topLevel[4],
                VariableDeclaration("prop", null),
                VariableDeclaration("x", null),
                VariableDeclaration("y", null),
                VariableDeclaration("z", null))

        val topLevelCasted = topLevelScope as List<NamedDeclaration>
        for (i in 0..4) {
            assertTrue(topLevel[i].scope!!.declaredEntities.containsAll(topLevelCasted))
            assertEquals(topLevelCasted.size, topLevel[i].scope!!.declaredEntities.size)
            assertFalse(topLevel[i].scope!!.declaredEntities.contains(testFunArg))
        }

        val testFunBody = testFun.body as StatementsNode
        assertEquals(listOf(testFunArg), testFunBody.scope!!.declaredEntities)
        assertEquals(testFun.scope, testFunBody.scope!!.parentScope)

        val barFunc = testFunBody.children[0] as FunctionDeclarationNode
        val barFuncFirstStatement = barFunc.body!!.children.single()
        assertEquals(listOf(VariableDeclaration("innerVal", null)), barFuncFirstStatement.scope!!.declaredEntities)

        assertEquals(setOf(VariableDeclaration("first", null), barFunc),
                testFunBody.children[1].scope!!.declaredEntities.toSet())
        assertEquals(setOf(VariableDeclaration("first", null), barFunc,
                VariableDeclaration("second", null)),
                testFunBody.children[2].scope!!.declaredEntities.toSet())

        assertTrue(testFunBody.children[2].scope!!.allEntities.containsAll(topLevelCasted))

        val forLoop = testFunBody.children[3].children.single() as ForLoopNode
        assertEquals(listOf(VariableDeclaration("i", null)),
                forLoop.body.scope!!.declaredEntities)

        val lambdaBody = ((testFunBody.children[4] as PropertyDeclarationNode).initExpr as FunctionLiteralNode).statements
        assertEquals(setOf(VariableDeclaration("x", null),
                VariableDeclaration("y", null),
                VariableDeclaration("z", null)), lambdaBody.scope!!.declaredEntities.toSet())

        assertFalse(testFunBody.children[5].scope!!.declaredEntities.contains(VariableDeclaration("i", null)))
        assertFalse(testFunBody.children[5].scope!!.declaredEntities.contains(VariableDeclaration("x", null)))
        assertFalse(testFunBody.children[5].scope!!.declaredEntities.contains(VariableDeclaration("y", null)))
        assertFalse(testFunBody.children[5].scope!!.declaredEntities.contains(VariableDeclaration("z", null)))
    }
}