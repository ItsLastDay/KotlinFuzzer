package ru.au.kotlinfuzzer.parsing

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree
import ru.au.kotlinfuzzer.ErrorExceptionThrower
import ru.au.kotlinfuzzer.generated.KotlinLexer
import ru.au.kotlinfuzzer.generated.KotlinParser
import java.io.File


fun getParseTreeFromFile(fname: String): ParseTree {
    val text = File(fname).readText()
            // Rewrite text, so that "1..2" is not lexed as "[float 1.; float .2]", but lexed as "[int 1; operator ..; int 2]"
            .replace("..", " .. ")
            // Rewrite text so that "1.toInt()" is translated to "1 .toInt()" - this allows parser to parse function call
            // instead of unparseable [floatLiteral, simpleName].
            // All occurences of "." cannot be replaced by " .", because this would break ordinary numbers like "1.0"
            .replace(Regex("""(\d+)(\.\w+\()"""),
                    { it.groupValues[1] + " " + it.groupValues[2] })
    val fstream = CharStreams.fromString(text)

    val lexer = KotlinLexer(fstream)
    val tokens = CommonTokenStream(lexer)

    val parser = KotlinParser(tokens)
    parser.removeErrorListeners()
    parser.errorHandler = ErrorExceptionThrower()

    return parser.kotlinFile()
}

