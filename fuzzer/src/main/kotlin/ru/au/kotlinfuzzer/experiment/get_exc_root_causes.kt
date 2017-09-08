package ru.au.kotlinfuzzer.experiment

import org.apache.logging.log4j.LogManager
import ru.au.kotlinfuzzer.fuzzing.SUCCESS_TEST_DIR
import ru.au.kotlinfuzzer.fuzzing.invokeKotlinc
import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter
import kotlin.test.fail

private val logger = LogManager.getLogger()

fun main(vararg args: String) {
    val outFile = File("./logs/root_causes.txt")
    val writer = PrintWriter(FileOutputStream(outFile))

    logger.info("Started `get exc root` experiment")
    writer.println("Started `get exc root` experiment")

    val dir = File("$SUCCESS_TEST_DIR/verified")
    System.err.close()
/*    dir.walk().filter { it.isFile && it.name.endsWith(".kt") }.sortedBy { it.length() }
            .forEach {
                val out = invokeKotlinc(it, myCp="./target/kotlin_fuzzer-1.0-SNAPSHOT-jar-with-dependencies.jar")
                if (!out.hasCompilerCrash()) {
                    println(it.name)
                }
            }
    fail()*/
    dir.walk().filter { it.isFile && it.name.endsWith(".kt") }.sortedBy { it.length() }
            //.filter { it.name.contains("starProjectedType.kt") }
            //.take(15)
            .forEach {
                val output = "\n" + invokeKotlinc(it, myCp="./target/kotlin_fuzzer-1.0-SNAPSHOT-jar-with-dependencies.jar").combinedOutput
                        // Erase all occurences of file name
                        .replace(Regex("at \\(\\d+,\\d+\\) in ${it.absolutePath}"), "")
                        .replace(it.absolutePath, "") + "\n"
                writer.println("File ${it.name}")
                logger.info("File ${it.name}")
                /*
                Typical stacktrace contains things like
                Caused by: java.lang.ClassCastException: org.jetbrains.kotlin.psi.KtUserType cannot be cast to org.jetbrains.kotlin.psi.KtNullableType
                    at org.jetbrains.kotlin.types.expressions.PatternMatchingTypingVisitor.checkTypeForIs(PatternMatchingTypingVisitor.kt:441)

                I want to extract such pairs of lines (one without "at", followed by one with "at").

                Sometimes, the pattern is different:
                exception ...
                    at ...
                    at ...
                Caused by: java.lang.AssertionError: Rewrite at slice LEXICAL_SCOPE key: REFERENCE_EXPRESSION old value: Snapshot(4) for CODE_BLOCK@1331836755 new value: Snapshot(0) for CODE_BLOCK@693178914

                 */
                //println(output)
                writer.println("ROOT CAUSES")
                logger.info("ROOT CAUSES")
                val causes = Regex("\n(\\S.+?\n([ \t]*at .*?\n){1,3}|Caused by:.*?\n)").findAll(output).toList()
                causes.forEach {
                    writer.println("\t${it.groupValues[1]}")
                    writer.flush()
                    logger.info("\t${it.groupValues[1]}")
                }

                if (causes.isEmpty()) {
                    println("Could not find root causes!")
                    fail()
                }
    }
}