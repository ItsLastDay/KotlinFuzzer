package ru.au.kotlinfuzzer

import org.junit.Test
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.mutation.AddNullability
import ru.au.kotlinfuzzer.mutation.DeleteNullability
import ru.au.kotlinfuzzer.mutation.mutateAST
import ru.au.kotlinfuzzer.mutation.mutateASTWith
import ru.au.kotlinfuzzer.util.getCompilerTestDataFullname

class RegressionTests {
    /**
     * There were issues with the first two added ast mutations: add\delete nullability.
     * Somehow, one FFN was becoming a direct parent of other FFN, which caused `parent` of FFN to be
     * invoked.
     *
     * This test runs mutation and makes sure that no exception is thrown.
     */
    @Test
    fun fuzzingNodeParentInvalidCall() {
        for (filename in listOf<String>(
                getCompilerTestDataFullname("codegen/java8/box/jvm8/inlineFromAnotherFile.kt"),
                getCompilerTestDataFullname("codegen/boxInline/argumentOrder/lambdaMigration.kt"),
                getCompilerTestDataFullname("codegen/boxInline/argumentOrder/extension.kt"),
                getCompilerTestDataFullname("codegen/box/coroutines/statementLikeLastExpression.kt")
        )) {
            val ast = buildASTFromFile(filename)
            for (ffast in mutateASTWith(ast, listOf(AddNullability(), DeleteNullability()))) {
                // Do nothing
            }
        }
    }


    /**
     * Exception kotlin.TypeCastException: null cannot be cast to non-null type ru.au.kotlinfuzzer.ast.GenericTypeParams
     */
    @Test
    fun typeCastToGenericTypes() {
        for (filename in listOf<String>(
                getCompilerTestDataFullname("codegen/boxInline/complexStack/simple2.kt")
        )) {
            val ast = buildASTFromFile(filename)
            for (ffast in mutateAST(ast)) {
                // Do nothing
            }
        }
    }

}