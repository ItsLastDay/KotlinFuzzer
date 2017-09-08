package ru.au.kotlinfuzzer.fuzzing

import org.apache.logging.log4j.LogManager
import ru.au.kotlinfuzzer.ast.ASTNode
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.ast.getTextFromAST
import ru.au.kotlinfuzzer.mutation.minimize
import ru.au.kotlinfuzzer.mutation.mutateAST
import java.io.File

private val logger = LogManager.getLogger()


val TEST_DIR = "fuzzing_output"
val SUCCESS_TEST_DIR = "$TEST_DIR/crashing_tests"
val REGULAR_TEST_DIR = "$TEST_DIR/regular_tests"
val TIMEOUT_MIN = 3L

fun fuzzFromFiles(files: List<File>) {
    logger.info("Started `fuzzFromFiles` function")
    val regularTestDir = File(REGULAR_TEST_DIR)
    files.parallelStream().forEach { file ->
        logger.info("Fuzzing file ${file.absolutePath}")
        try {
            val ast = buildASTFromFile(file)
            for (mutatedAST in mutateAST(ast)) {
                val writtenFile = writeMutatedToFile(file, mutatedAST) ?: continue
                val compilerResult = invokeKotlinc(writtenFile)
                analyzeResults(compilerResult, writtenFile, mutatedAST, File("$SUCCESS_TEST_DIR/${writtenFile.name}"))
            }
        }
        catch(exc: Throwable) {
            logger.error("Exception $exc thrown when building AST or mutating file ${file.absolutePath}")
        }
    }
    // Do not waste disk space
    regularTestDir.deleteRecursively()
    regularTestDir.mkdir()
}

class KotlincInvokeStatus(
        val combinedOutput: String,
        val isCompileSuccess: Boolean,
        val hasException: Boolean,
        val hasTimeout: Boolean
) {
    fun hasCompilerCrash(): Boolean = hasTimeout || hasException

    fun hasCompilationError(): Boolean = !isCompileSuccess
}

fun writeMutatedToFile(sourceFile: File, mutatedAST: ASTNode): File? {
    val mutatedText = getTextFromAST(mutatedAST, true)
    val textHash = mutatedText.hashCode()
    val destFile = File("$REGULAR_TEST_DIR/${sourceFile.name}$textHash.kt") // .kt is essential for kotlinc
    // If file with such text was already written, ignore it
    if (destFile.isFile) {
        return null
    }
    logger.info("Writing mutated file (length ${mutatedText.length}) to ${destFile.name}")
    destFile.writeText(mutatedText)
    return destFile
}

fun analyzeResults(result: KotlincInvokeStatus,
                   writtenFile: File,
                   ast: ASTNode,
                   fileToStore: File
): Boolean {
    logger.info("Compilation ${if (!result.hasCompilationError()) "success" else "fail"}")
    if (result.hasCompilerCrash()) {
        logger.info("Kotlinc crashed! Output: ${result.combinedOutput}")
        try {
            val minimized = minimize(ast)
            fileToStore.writeText(getTextFromAST(minimized, true))
        } catch(exc: Exception) {
            writtenFile.copyTo(fileToStore)
        }

        return true
    } else {
        logger.info("No crash")
        return false
    }
}
