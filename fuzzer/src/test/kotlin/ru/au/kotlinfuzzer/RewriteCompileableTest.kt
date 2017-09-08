package ru.au.kotlinfuzzer

import org.apache.logging.log4j.LogManager
import org.junit.Test
import org.junit.rules.TemporaryFolder
import ru.au.kotlinfuzzer.ast.ASTNode
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.ast.getTextFromAST
import ru.au.kotlinfuzzer.fuzzing.invokeKotlinc
import ru.au.kotlinfuzzer.util.compilerTestDataFolder
import java.io.File
import kotlin.test.assertTrue

val logger = LogManager.getLogger()

class RewriteCompileableTest {
    companion object {
        val folder = TemporaryFolder()

        init {
            folder.create()
        }
    }

    /**
     * Manual test: check how many files from compiler/testData are compileable after
     * we rewrite (i.e. undergo file -> parse tree -> AST -> text) them.
     */
    @Test
    fun rewriteKotlinTestDataIsCompileable() {
        logger.info("rewriteKotlinTestDataIsCompileable test started")
        val kotlinCompilerTests = compilerTestDataFolder.walk().filter { it.isFile && it.extension == "kt" }

        var wronglyCompiled = 0
        var allFiles = 0
        var nonParsed = 0

        for (file in kotlinCompilerTests) {
            allFiles++

            val ast: ASTNode
            try {
                ast = buildASTFromFile(file)
            } catch(e: Exception) {
                logger.fatal("Could not parse ${file.name}")
                nonParsed++
                continue
            }
            val writtenText = getTextFromAST(ast, true)

            val writtenFile: File?
            try {
                writtenFile = folder.newFile("${file.parentFile.name}_${file.name}")
            } catch(e: Exception) {
                logger.error("Could not create file ${file.absolutePath}")
                continue
            }
            writtenFile.writeText(writtenText)

            logger.info("File ${file.name}: ${file.readText().length} characters in original, ${writtenText.length} characters in rewritten")

            val compilerResult = invokeKotlinc(writtenFile, true)
            if (compilerResult.hasCompilationError()) {
                logger.error("File ${file.name} rewritten:\n ${writtenText}")
                logger.error("Compilation error: ${compilerResult.combinedOutput}\n\n")
                //fail("Rewritten file ${file.name} should compile")
                wronglyCompiled++
            } else {
                logger.info("Successfully compiled ${file.name}")
            }

            logger.info("Processed ${allFiles}, errors: ${wronglyCompiled}, not parsed: $nonParsed")
        }

        assertTrue(wronglyCompiled * 2 <= allFiles)
    }
}