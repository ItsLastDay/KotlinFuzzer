package ru.au.kotlinfuzzer

import ru.au.kotlinfuzzer.fuzzing.fuzzFromFiles
import java.io.File
import java.util.*
import java.util.Collections.singletonList

fun doBasicFuzzing() {
    println("Running 'doBasicFuzzing' function")
    val folder = File("src/test/resources/compilerTestData/")
    val files = folder.walk().filter { it.isFile }.toList()
    Collections.shuffle(files)
    fuzzFromFiles(files)
}

fun fuzzOneFile() {
    val file = "src/test/resources/compilerTestData/asFunKBig.kt"
    fuzzFromFiles(singletonList(File(file)))
}

fun main(args: Array<String>) {
/*
    fuzzOneFile()
*/
    doBasicFuzzing()
}
