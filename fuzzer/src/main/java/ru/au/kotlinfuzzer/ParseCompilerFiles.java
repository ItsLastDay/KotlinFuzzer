package ru.au.kotlinfuzzer;

import org.antlr.v4.runtime.*;
import ru.au.kotlinfuzzer.generated.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class ParseCompilerFiles {
    static private int runOneFile(Path filePath, PrintWriter writer) {
        CharStream fstream = null;
        try {
            fstream = CharStreams.fromFileName(filePath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        KotlinLexer lexer = new KotlinLexer(fstream);
        TokenStream tokens = new CommonTokenStream(lexer);

        KotlinListener basicListener = new KotlinBaseListener();

        KotlinParser parser = new KotlinParser(tokens);
        parser.addParseListener(basicListener);

        parser.removeErrorListeners();
        parser.addErrorListener(new PrintWriterErrorListener(writer));
        parser.setErrorHandler(new ErrorExceptionThrower());

        int ret = 1;
        try {
            parser.kotlinFile();
        } catch (RuntimeException e) {
            writer.println(e.getMessage());
            ret = 0;
        }
        assert(parser.isMatchedEOF());
        writer.println(ret);
        return ret;
    }

    static private void parseCompilerTestData() throws IOException {
        Path baseDir = Paths.get("/home/last/AU/KotlinFuzzer/kotlin-dev/kotlin/compiler/testData/");
        Stream<Path> stream = Files.walk(baseDir)
                .filter(s -> s.toString().endsWith(".kt"));

        String logName = String.format("log_%s.txt", LocalDateTime.now().toString());
        PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(logName)));

        Map<Path, Integer> errorsByDirectory = new TreeMap<>();

        System.out.println(stream.peek(writer::println).mapToInt(filePath -> {
            int parseResult = runOneFile(filePath, writer);
            Path curDir = filePath.getParent();
            while (!curDir.equals(baseDir.getParent())) {
                int oldVal = errorsByDirectory.getOrDefault(curDir, 0);
                errorsByDirectory.put(curDir, oldVal + (1 - parseResult));
                curDir = curDir.getParent();
            }
            return parseResult;
        }).sum());

        writer.write("\n\nStatistics (errors by directory):\n");
        for (Map.Entry<Path, Integer> entry: errorsByDirectory.entrySet()) {
            writer.format("%s: %d\n", entry.getKey().toString().replaceFirst(baseDir.toString(), ""), entry.getValue());
        }

        writer.flush();
    }

    private void testOneFile(String fname) {
        PrintWriter wr = new PrintWriter(System.out);
        runOneFile(Paths.get(fname), wr);
        wr.flush();
    }

    public static void main(String[] args) throws IOException {
        parseCompilerTestData();
    }
}
