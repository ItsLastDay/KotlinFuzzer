package ru.au.kotlinfuzzer.util

import java.io.File

fun getMyTestDataFullname(fname: String)
    = "src/test/resources/testData/$fname"

fun getCompilerTestDataFullname(fname: String)
    = "src/test/resources/compilerTestData/$fname"

val compilerTestDataFolder = File("src/test/resources/compilerTestData")