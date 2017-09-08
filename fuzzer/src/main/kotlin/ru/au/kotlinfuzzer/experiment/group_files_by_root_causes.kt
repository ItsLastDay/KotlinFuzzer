package ru.au.kotlinfuzzer.experiment

import java.io.File

fun main(vararg args: String) {
    val rootCauses = File("./logs/root_causes.txt").readLines()
            .map {
                it.substringAfter("[main] ")
            }
            .filter {
                !it.contains("Running kotlinc on file") && it.isNotEmpty()
                && it != "Started `get exc root` experiment"
            }

    var idx = 0

    val rootHashToFiles = mutableMapOf<String, MutableList<String>>()

    while (idx < rootCauses.size) {
        if (!rootCauses[idx].startsWith("File ")) {
            throw IllegalStateException()
        }

        val curFileName = rootCauses[idx].substringAfter("File ")

        ++idx
        if (!(rootCauses[idx] == "ROOT CAUSES")) {
            throw IllegalStateException()
        }

        ++idx
        val baseIdx = idx

        while (idx < rootCauses.size && !rootCauses[idx].startsWith("File ")) {
            ++idx
        }

        val curCauses: String = rootCauses.subList(baseIdx, idx).joinToString(",")
                // Erase things like "No resolved call for 'mutable'" (there are many)
                .replace(Regex("No resolved call for '.*?'"), "")
                // Erase things like "[ERROR : Type for MyClass::class.java.getAnnotation((Ann)?::class.java)]",
                // because it is source-specific.
                // Care not to erase things like "[ERROR : Unsubstituted type for <ERROR CLASS>] " - it does not contain source code
                .replace(Regex("Type for .*?]"), "]")
                // Erase things like "Error type encountered: org.jetbrains.kotlin.types.ErrorUtils$UninferredParameterTypeConstructor@1a465c0c (ErrorType)"
                // Mainly, the number at the end must be erased.
                .replace(Regex("org.jetbrains.kotlin.types.ErrorUtils\\\$UninferredParameterTypeConstructor@.*? "), "org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor ")
                // Erase instruction number in things like "Error at instruction #6 DUP"
                .replace(Regex("Error at instruction #\\d+"), "Error at instruction")
                // Erase method name\args in things like "Couldn't transform method node: box ()Ljava/lang/String;:,"
                .replace(Regex("Couldn't transform method node: .*?:,"), "Couldn't transform method node:,")
                // Erase method name in things like "Method inlining inlineFun2({stub()}):"
                .replace(Regex("Method inlining .*?:"), "Method inlining:")
                // Erase method name in things like "Lambda inlining SeveralUsage_kt673778945Kt$box$result$1:"
                .replace(Regex("Lambda inlining .*?:"), "Lambda inlining:")
                // Erase source-specific numbers from things like
                // "Rewrite at slice LEXICAL_SCOPE key: REFERENCE_EXPRESSION old value: Snapshot(0) for CODE_BLOCK@1261781644 new value: Snapshot(0) for CODE_BLOCK@1140435550,"
                .replace(Regex("Snapshot\\(\\d+\\)"), "Snapshot")
                .replace(Regex("CODE_BLOCK@\\d+"), "CODE_BLOCK")
                .replace(Regex("FUNCTION_INNER_SCOPE@\\d+"), "FUNCTION_INNER_SCOPE")
                // Erase source fragments from things like
                // "})(A("OK")),	at org.jetbrains.kotlin.com.intellij.openapi.diagnostic.DefaultLogger.error(DefaultLogger.java:71)"
                .replace(Regex("[^\t]*?\tat org.jetbrains.kotlin.com.intellij.openapi.diagnostic.DefaultLogger.error\\(DefaultLogger.java:71\\)"), "")
                // Erase source fragments from things like
                // "not resolved to variable descriptor with accessors: (x)?::id,"
                .replace(Regex("not resolved to variable descriptor with accessors:.*?,"),
                        "not resolved to variable descriptor with accessors")
                // All OutOfMemoryError-s are really the same
                .replace(Regex("java.lang.OutOfMemoryError:.*"), "java.lang.OutOfMemoryError")
                // Erase class name from things like "Error generating class file test/_33Parameters_kt1533000850Kt.class
                .replace(Regex("Error generating class file .*?.class"), "Error generating class file ")
                // Erase source-specific text from things like
                // "Error at instruction INVOKESTATIC RemAssignmentOperation_kt_378550291Kt.remAssign (LA;ILkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;: Cannot pop operand off an empty stack.,"
                .replace(Regex("Error at instruction INVOKESTATIC .*?: Cannot pop operand"), "Error at instruction INVOKESTATIC: Cannot pop operand")
                // Erase source-specific text from things like
                // "Error at instruction INVOKEVIRTUAL ArrayWrapper.plus (LArrayWrapper;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;: Cannot pop operand"
                .replace(Regex("Error at instruction INVOKEVIRTUAL .*?: Cannot pop operand"), "Error at instruction INVOKEVIRTUAL: Cannot pop operand")
                // Erase source-specific text from things like
                // "No declaration for inherited open suspend fun foo(): kotlin.Int defined in Z[SimpleFunctionDescriptorImpl@751f4d3b],	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope"
                .replace(Regex("No declaration for inherited .*?\t"), "No declaration\t")
                // Erase whitespaces
                .trim()
                // Skip introductory phrases in the beginning (I could do it in the middle as well, but I think it lowers readability)
                .removePrefix("Caused by: ")
                .removePrefix("The root cause was thrown at: ")
                .trim()
                // Erase source-specific text from things like
                // "Couldn't build context for public final val obj: box.Local.obj.<no name provided> defined in box.Local[PropertyDescriptorImpl@55f5ea03],	at org.jetbrains.kotlin"
                .replace(Regex("Couldn't build context for .*?\t"), "Couldn't build context\t")
                // Erase source-specific text from things like
                // "Caused by: java.lang.RuntimeException: Trying to access skipped parameter: Lkotlin/jvm/functions/Function0; at 0,	at org.jetbrains"
                .replace(Regex("Trying to access skipped parameter:.*\t"), "Trying to access skipped parameter\t")
                // Erase source-specific text from things like
                // "Error at instruction 1448"
                .replace(Regex("Error at instruction \\d+"), "Error at instruction ")
                // Erase source-specific text from things like
                // "Don't know how to generate outer expression for class A,	at org.jetbrains.kotlin"
                .replace(Regex("Don't know how to generate outer expression for class .*?\t"),
                        "Don't know how to generate outer expression\t")
                // Erase source-specific code from things like
                // "Rewriting key Int?: Ext {public final fun kotlin.Int?.bar(): kotlin.String defined in SuperFoo[SimpleFunctionDescriptorImpl@42e0d068]} for implicit smart cast on baz: was Int, now Foo,	at org.jetbrains.kotlin."
                .replace(Regex("Rewriting key .*? for implicit smart cast .*?\t"), "Rewriting key for smart cast\t")

        rootHashToFiles.getOrPut(curCauses, {mutableListOf()}).add(curFileName)
    }

    // Check LCS of all pairs of traces
    /*for (cause1 in rootHashToFiles.keys) {
        var maxSim = -1.0
        var argmax = ""
        for (cause2 in rootHashToFiles.keys) {
            if (cause1 == cause2)
                continue
            val lcs = calcLongestCommonSubsequence(cause1, cause2)
            val simPercent = lcs / maxOf(cause1.length, cause2.length).toDouble()
            if (simPercent > maxSim) {
                maxSim = simPercent
                argmax = cause2
            }
        }
        if (maxSim > 0.97) {
            println("$cause1\n$maxSim\n$argmax\n\n\n")
        }
    }*/

    println(rootHashToFiles.size)
    for (cause in rootHashToFiles.keys.sortedWith(compareBy({ rootHashToFiles[it]!!.size }, { it }))) {
        println("${rootHashToFiles[cause]!!.size}, $cause")
        for (fname in rootHashToFiles[cause]!!) {
            println("\t$fname")
        }
    }
}