package ru.au.kotlinfuzzer.experiment

import org.apache.logging.log4j.LogManager
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.ast.getTextFromAST
import ru.au.kotlinfuzzer.fuzzing.SUCCESS_TEST_DIR
import ru.au.kotlinfuzzer.mutation.realMinimize
import java.io.File

private val logger = LogManager.getLogger()


fun main(args: Array<String>) {
    System.err.close() // suppress raw compiler output
    logger.info("Started `minimize verified` function")
    val filesToCheck = File("$SUCCESS_TEST_DIR/verified").listFiles()
            .filter { it.isFile }
            .sortedBy { it.length() }
            .filter { it.length() < 1300 }

    filesToCheck.forEach {
        println("Checking file ${it.name}")
        try {
            val minimized = realMinimize(buildASTFromFile(it))
            if (minimized != null) {
                println("\tSuccess!")
                val minText = getTextFromAST(minimized, true)
                println(minText)
                File("$SUCCESS_TEST_DIR/verified/minimized/${it.name}_minimized.kt")
                        .writeText(minText)
            } else {
                // Could not minimize
            }
        } catch (ex: Throwable) {
            println("Exception $ex")
        }
    }
}