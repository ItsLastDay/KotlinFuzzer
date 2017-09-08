package ru.au.kotlinfuzzer

import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.ast.getTextFromAST
import ru.au.kotlinfuzzer.mutation.mutateASTShallow
import ru.au.kotlinfuzzer.util.getMyTestDataFullname
import java.io.File
import kotlin.test.assertEquals


@RunWith(Suite::class)
@Suite.SuiteClasses(
        WriterFeaturesTest::class
)
class ASTWriterTestSuite {

}

class WriterFeaturesTest {

    private fun runWriterTest(filenameOrig: String, expectedIsSame: Boolean=false) {
        val filename = getMyTestDataFullname(filenameOrig)
        val ast = buildASTFromFile(filename)

        val writtenText = getTextFromAST(ast)
        val suffix = if (expectedIsSame) "" else "_rewritten"
        val expectedText = File("$filename$suffix").readText()
        assertEquals(expectedText, writtenText)

        val writtenMutatedText = getTextFromAST(mutateASTShallow(ast))
        assertEquals(expectedText, writtenMutatedText)
    }

    @Test
    fun writePreamble() {
        runWriterTest("preamble.kt")
    }

    @Test
    fun writeFunctionDefinition() {
        runWriterTest("functions_medium.kt")
    }

    @Test
    fun writeAtomicExpression() {
        runWriterTest("atomic_expression.kt")
    }

    @Test
    fun writeDeclarationHeaders() {
        runWriterTest("declaration_simple.kt")
    }

    @Test
    fun writeNameWithSpacesCorrectly() {
        runWriterTest("name_with_spaces.kt", true)
    }

    @Test
    fun writeModifiers() {
        runWriterTest("modifiers.kt")
    }

    @Test
    fun writeFunctionBodies() {
        runWriterTest("functions_simple.kt")
    }

    @Test
    fun writeWhereConstraints() {
        runWriterTest("where_constraints.kt")
    }

    @Test
    fun writeBinaryOperations() {
        runWriterTest("binary_ops.kt")
    }

    @Test
    fun writeIfWithoutThen() {
        runWriterTest("if_empty_then.kt", true)
    }

    @Ignore // prohibited while without body - interferes with `callSuffix` rule.
    @Test
    fun writeWhileWithoutBody() {
        runWriterTest("while_empty_body.kt", true)
    }

    @Test
    fun writeCalls() {
        runWriterTest("calls.kt")
    }

    @Test
    fun writeUnaryOps() {
        runWriterTest("unary_ops.kt")
    }

    @Test
    fun writeGenericTypesAndParams() {
        runWriterTest("generic_types.kt")
    }

    @Test
    fun writeClass() {
        runWriterTest("class.kt")
    }
}