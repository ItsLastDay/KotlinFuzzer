package ru.au.kotlinfuzzer

import org.junit.Ignore
import org.junit.Test
import org.junit.rules.TemporaryFolder
import ru.au.kotlinfuzzer.ast.*
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.fuzzing.*
import ru.au.kotlinfuzzer.mutation.AddFunctionModifier
import ru.au.kotlinfuzzer.mutation.buildFuzzingFriendlyASTFromFile
import ru.au.kotlinfuzzer.mutation.getTypedNode
import ru.au.kotlinfuzzer.mutation.mutateAST
import ru.au.kotlinfuzzer.util.getMyTestDataFullname
import java.io.File
import kotlin.test.*


class FuzzingProcessTest {
    companion object {
        val folder = TemporaryFolder()

        init {
            folder.create()
        }
    }

    /**
     * Check that changes made in `mutateAST` function can be written to text.
     *
     * Since `mutateAST` is probabilistic, just run it many times and check differences
     * with baseline text.
     */
    @Test
    fun checkFuzzingResultIsRewritten() {
        val ast = buildASTFromFile(getMyTestDataFullname("nullability.kt"))
        val writtenAST = getTextFromAST(ast)

        1.rangeTo(100_000).forEach({
            for (ffast in mutateAST(ast)) {
                val rewrittenText = getTextFromAST(ffast)
                if (rewrittenText != writtenAST && rewrittenText != "") {
                    return
                }
            }
        })

        fail("No different source text after many iterations")
    }

    @Test
    fun writeMutatedToFileNotNullForNewFile() {
        val fileToWrite = File(getMyTestDataFullname("preamble.kt"))
        val resFile = writeMutatedToFile(fileToWrite, buildASTFromFile(fileToWrite))
        assertNotNull(resFile)
        resFile!!.delete()
    }

    @Test
    fun writeMutatedToFileTwoTimesNull() {
        val fileToWrite = File(getMyTestDataFullname("nullability.kt"))
        val resFile = writeMutatedToFile(fileToWrite, buildASTFromFile(fileToWrite))
        assertNotNull(resFile)
        val resFileSecond = writeMutatedToFile(fileToWrite, buildASTFromFile(fileToWrite))
        assertNull(resFileSecond)
        resFile!!.delete()
    }

    @org.junit.Ignore // this test takes too long to run when there are many generated files
    @Test
    fun noKotlincResultFilesInSourceTree() {
        val fileWithPackage = File(getMyTestDataFullname("file_with_package.kt"))

        invokeKotlinc(fileWithPackage)
        val blaFolders = File("src/../").walk().filter {
            it.isDirectory && it.name == "bla"
                    // There is one folder where compiler output may be
                    && !it.parent.contains("fuzzing_output/compiler_output")
        }.toList()
        assertEquals(0, blaFolders.size)
    }

    @Test
    fun analyzeKotlincResultCrashing() {
        for (file in listOf("kt11902.kt", "typeAliasCrashing.kt")) {
            val crashingFile = File(getMyTestDataFullname(file))

            val compilerResult = invokeKotlinc(crashingFile)
            val fileToStore = folder.newFile()
            assertTrue(analyzeResults(compilerResult, crashingFile, buildASTFromFile(crashingFile), fileToStore))
        }
    }

    @Test
    fun analyzeKotlincResultClean() {
        val cleanFile = File(getMyTestDataFullname("preamble.kt"))

        val compilerResult = invokeKotlinc(cleanFile)
        val fileToStore = folder.newFile()
        assertFalse(analyzeResults(compilerResult, cleanFile, buildASTFromFile(cleanFile), fileToStore))
    }

    @Test
    fun analyzeKotlincResultCompileErrorNoCrash() {
        val errorFile = File(getMyTestDataFullname("declaration_simple.kt"))

        val compilerResult = invokeKotlinc(errorFile)
        val fileToStore = folder.newFile()
        assertFalse(analyzeResults(compilerResult, errorFile, buildASTFromFile(errorFile), fileToStore))
    }

    /**
     * Test that different compilations do not interfere (e.g. no "already declared function" errors)
     */
    @Test
    fun invokeKotlincTwiceNoError() {
        val compileableFile = File(getMyTestDataFullname("func_generic.kt"))

        val compilerResult = invokeKotlinc(compileableFile)
        assertFalse(compilerResult.hasCompilationError())
        val compilerResultTwo = invokeKotlinc(compileableFile)
        assertFalse(compilerResultTwo.hasCompilationError())
    }

    @Test
    fun testRollback() {
        val filename = getMyTestDataFullname("modifiers.kt")
        val ffast = buildFuzzingFriendlyASTFromFile(filename)

        val topLevel = getTypedNode<KotlinFileNode>(ffast).membersTyped.children
        val foo = getTypedNode<FunctionDeclarationNode>(topLevel[1])
        val fooModifiers = foo.modifiers as FuzzingFriendlyNode
        assertEquals(3, (fooModifiers.node as ModifiersNode).rawModifiersAnnotations.size)
        AddFunctionModifier().apply(fooModifiers)
        assertEquals(4, (fooModifiers.node as ModifiersNode).rawModifiersAnnotations.size)

        ffast.rollbackToOriginal()
        assertEquals(3, (fooModifiers.node as ModifiersNode).rawModifiersAnnotations.size)
    }

    @Ignore // TODO: Need to look further into this.
    // Checks that kotlin.reflection, kotlin.test and kotlin.coroutines do not mess with compilation.
    @Test
    fun compileCommonLibraries() {
        val file = File(getMyTestDataFullname("common_libs.kt"))
        assertFalse(invokeKotlinc(file).hasCompilationError())
    }

    // Check that if ASTNode had child that is null, after inserting holes
    // it becomes FuzzingFriendlyNode(null).
    // On the contrary, other nullable types (e.g. String?) should not become FFN-s.
    @Test
    fun ffnNullChild() {
        run {
            val filename = getMyTestDataFullname("func_add_receiver.kt")
            val ffast = buildFuzzingFriendlyASTFromFile(filename)

            val foo = getTypedNode<FunctionDeclarationNode>(getTypedNode<KotlinFileNode>(ffast).membersTyped.children[2])
            assertNotNull(foo.receiverType)
            assertNull((foo.receiverType as FuzzingFriendlyNode).node)

            val undecorated = makeFuzzingUnfriendly(ffast)
            val fooUndec = getTypedNode<KotlinFileNode>(undecorated!!).membersTyped.children[2]
            assertNull(getTypedNode<FunctionDeclarationNode>(fooUndec).receiverType)
        }

        run {
            val filename = getMyTestDataFullname("preamble.kt")
            val ffast = buildFuzzingFriendlyASTFromFile(filename)

            val import = getTypedNode<ImportNode>(getTypedNode<KotlinFileNode>(ffast).membersTyped.children[1])
            assertNull(import.alias)
            makeFuzzingUnfriendly(ffast)
        }
    }

    @Ignore // heavy test
    @Test
    fun checkTimeoutingFile() {
        val invokeResult = invokeKotlinc(File(getMyTestDataFullname("32Parameters.kt747762843.kt")))
        assertTrue(invokeResult.hasTimeout)
    }
}