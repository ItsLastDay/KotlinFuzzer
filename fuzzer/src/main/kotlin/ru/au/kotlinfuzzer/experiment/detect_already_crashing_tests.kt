package ru.au.kotlinfuzzer.experiment

import ru.au.kotlinfuzzer.fuzzing.invokeKotlinc
import java.io.File

fun main(vararg args: String) {
    val folder = File("src/test/resources/compilerTestData/")
    val files = folder.walk().filter { it.isFile }.toList()

    files.parallelStream().forEach {
        if (invokeKotlinc(it).hasCompilerCrash()) {
            println(it.absolutePath)
        }
    }

}