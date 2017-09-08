package ru.au.kotlinfuzzer.fuzzing

import org.apache.logging.log4j.LogManager
import java.io.File
import java.lang.Math.max

private val logger = LogManager.getLogger()

fun getBaseName(file: File) = file.name.substringBefore(".kt")

fun calcLongestCommonSubsequence(s: String, t: String): Int {
    val n = s.length
    val m = t.length
    val dp = Array(2, { Array(m + 1, {0}) })

    for (i in 0..n) {
        dp[(i + 1) % 2].fill(0)

        for (j in 0..m) {
            if (j < m)
                dp[i % 2][j + 1] = max(dp[i % 2][j + 1], dp[i % 2][j])
            if (i < n)
                dp[(i + 1) % 2][j] = max(dp[(i + 1) % 2][j], dp[i % 2][j])
            if (i < n && j < m && s[i] == t[j]) {
                dp[(i + 1) % 2][j + 1] = max(dp[(i + 1) % 2][j + 1], dp[i % 2][j] + 1)
            }
        }
    }

    return dp[n % 2][m]
}

private fun testLCS() {
    if (calcLongestCommonSubsequence("abc", "cde") != 1) {
        throw AssertionError("Assertion failed")
    }
    if (calcLongestCommonSubsequence("abc", "abcabc") != 3) {
        throw AssertionError("Assertion failed")
    }
    if (calcLongestCommonSubsequence("abc", "ppppaxxxxxxbyyyyczzzz") != 3) {
        throw AssertionError("Assertion failed")
    }
    if (calcLongestCommonSubsequence("", "") != 0) {
        throw AssertionError("Assertion failed")
    }
    if (calcLongestCommonSubsequence("qwertzxcv", "ecvwxert") != 4) {
        throw AssertionError("Assertion failed")
    }
    val longString = "".padStart(5000, 'a')
    if (calcLongestCommonSubsequence(longString, longString) != 5000) {
        throw AssertionError("Assertion failed")
    }
}

private fun getRootCauses(fileToCheck: File): String {
    val invokeResult = invokeKotlinc(fileToCheck,
            myCp = "./target/kotlin_fuzzer-1.0-SNAPSHOT-jar-with-dependencies.jar")
    if (invokeResult.hasTimeout)
        return "timeout"

    val output = ("\n" + invokeResult.combinedOutput + "\n")
            .replace(Regex("at \\(\\d+,\\d+\\) in ${fileToCheck.absolutePath}"), "")
            .replace(fileToCheck.absolutePath, "")
    val foundCauses = Regex("\n(\\S.+?\n[ \t]*at .*?|Caused by:.*?)\n").findAll(output).toList()
    if (foundCauses.isEmpty() && invokeResult.hasCompilerCrash()) {
        println("Could not find causes for file ${fileToCheck.absolutePath}. Please check the file manually.")
        println("output:\n$output")
        throw IllegalArgumentException()
    }
    return foundCauses.joinToString("\n") {
        it.groupValues[1]
    }
}

fun main(args: Array<String>) {
    testLCS()
    System.err.close() // suppress raw compiler output
    logger.info("Started filtering tests in `crashing_tests` directory")
    val filesToCheck = File(SUCCESS_TEST_DIR).listFiles()
            .filter { it.isFile }
            //.filter { it.name.contains("starProjectedType") }
            .sortedBy { it.length() }

    for (fileToCheck in filesToCheck) {
        println(fileToCheck.name)
        val outputCurrent = getRootCauses(fileToCheck)
        logger.info("Checking file ${fileToCheck.name}")
        logger.info("output current")
        logger.info(outputCurrent)

        val alreadyVerifiedSameName = File("$SUCCESS_TEST_DIR/verified").listFiles()
                .filter { fl -> getBaseName(fl) == getBaseName(fileToCheck) }
        val newNameArchive = File("$SUCCESS_TEST_DIR/archive/${fileToCheck.name}")
        val newNameVerified = File("$SUCCESS_TEST_DIR/verified/${fileToCheck.name}")

        if (outputCurrent.isEmpty()) {
            fileToCheck.renameTo(newNameArchive)
            continue
        }

        if (newNameArchive.isFile || newNameVerified.isFile) {
            fileToCheck.delete()
            logger.info("File already in archive or verified")
            continue
        }

        if (outputCurrent.length > 50_000 &&
                alreadyVerifiedSameName.isNotEmpty()) {
            logger.info("Cannot reason about file: output too long (${outputCurrent.length})")
            continue
        }

        val hasDuplicate = alreadyVerifiedSameName
                .any { fl ->
                    val outputGroundTruth = getRootCauses(fl)
                    logger.info("output GT")
                    logger.info(outputGroundTruth)
                    logger.info("LenCurrent=${outputCurrent.length}, lenGT=${outputGroundTruth.length}")
                    val mxLen = max(outputCurrent.length, outputGroundTruth.length)
                    val szThreshold = (mxLen * 0.90).toInt()
                    val inCommon = calcLongestCommonSubsequence(outputCurrent, outputGroundTruth)
                    logger.info("Exception has $inCommon common characters with ${fl.name}")
                    logger.info("Threshold is $szThreshold")
                    inCommon >= szThreshold
                }

        val newName = if (hasDuplicate) newNameArchive else newNameVerified
        if (hasDuplicate) {
            logger.info("Filtering ${fileToCheck.name}: renaming to ${newName.absolutePath}")
        } else {
            logger.info("Test ${fileToCheck.name} is unique: moving to ${newName.absolutePath}")
        }
        fileToCheck.renameTo(newName)
    }
}