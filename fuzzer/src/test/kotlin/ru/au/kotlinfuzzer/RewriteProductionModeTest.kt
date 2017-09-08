package ru.au.kotlinfuzzer

import org.junit.Test
import ru.au.kotlinfuzzer.ast.builders.buildASTFromFile
import ru.au.kotlinfuzzer.ast.getTextFromAST
import ru.au.kotlinfuzzer.util.getMyTestDataFullname
import kotlin.test.assertTrue

/**
 * Check that rewriting in "production mode" (i.e. writing NotImplementedNode-s text)
 * results in sane files.
 */
class RewriteProductionModeTest {
    private fun runRewriteProductionTest(filename: String,
                                         needReplaceSpaces: Boolean,
                                         stringsToCheck: List<String>,
                                         shouldContain: Boolean) {
        val ast = buildASTFromFile(getMyTestDataFullname(filename))
        var rewritten = getTextFromAST(ast, true)
        if (needReplaceSpaces)
            rewritten = rewritten.replace("\n", "").replace(" ", "")

        stringsToCheck.forEach {
            assertTrue(!rewritten.contains(it) xor shouldContain)
        }
    }


    /**
     * During rewrite, sometimes classes were written
     * with double '{}' parenthesis pair.
     *
     * Ensure that this one is compileable.
     */
    @Test
    fun classBodyDoubleParenthesis() {
        runRewriteProductionTest("kt501.kt", true,
                listOf("{{init"), false)
    }

    @Test
    fun classPrimaryConstructor() {
        runRewriteProductionTest("class_constructor.kt", true,
                listOf("A(valx:Int,vary:String)"), true)
    }

    @Test
    fun functionGenericParams() {
        runRewriteProductionTest("func_generic.kt", false,
                listOf("fun <T>"), true)
    }

    @Test
    fun classDelegationAndGenerics() {
        runRewriteProductionTest("class_inheritance_generic.kt",
                false,
                listOf("Parent<T>",
                        "Foo<T, X, Y>",
                        "Derived: Parent<Int>, Simple",
                        "Star<T : Star<T>>",
                        "A<R>: Int by 1, String(\"abc\"), Parent<Simple>"),
                true)
    }

    @Test
    fun enumClass() {
        runRewriteProductionTest("enum_class.kt",
                true,
                listOf("enumclassX{A,B,C,}",
                        "enumclassY(valt:Int){QWE(123)"),
                true)
    }

    @Test
    fun objectLiteral() {
        runRewriteProductionTest("object_literal_and_map.kt",
                false,
                listOf("a.map({it * 2})",
                        "object: IOther{",
                        "override val x: String",
                        "{\n\n}\n}"),
                true)
    }

    @Test
    fun class_keyword() {
        runRewriteProductionTest("class_keyword.kt",
                false,
                listOf("A::class"),
                true)
    }

    @Test
    fun functionCall() {
        runRewriteProductionTest("function_call.kt",
                false,
                listOf("Box<Int>(1)"), // this could be parsed as "Box < Int > 1"
                true)
    }

    // Things like "1.toInt()" were lexed incorrectly and could not be parsed: [floatLiteral, simpleName]
    @Test
    fun numberReceiver() {
        runRewriteProductionTest("number_receiver.kt",
                false,
                listOf("1.toLong()",
                        "1.0.toInt()",
                        "c1.toInt()",
                        "1.01e4"),
                true)
    }

    @Test
    fun objectDelegation() {
        runRewriteProductionTest("object.kt",
                false,
                listOf(": Any"),
                true)
    }

    @Test
    fun propGetterSetter() {
        runRewriteProductionTest("property_get_set.kt",
                false,
                listOf("get() = \"1\"",
                        "get() = \"2\"\n",
                        "set(value) {\n }"),
                true)
    }

    @Test
    fun varianceAnnotationParam() {
        runRewriteProductionTest("variance_in_param.kt",
                false,
                listOf("<in Nothing>",
                        "<out Nothing>"),
                true)
    }
}