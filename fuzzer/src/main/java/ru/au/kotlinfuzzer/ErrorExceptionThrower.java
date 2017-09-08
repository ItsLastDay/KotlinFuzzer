package ru.au.kotlinfuzzer;

import org.antlr.v4.runtime.*;

// Taken from https://github.com/ivanyu/logical-rules-parser-antlr/blob/master/src/main/java/me/ivanyu/compiler/ExceptionThrowingErrorHandler.java
/**
 * Error handler which throws exception on any parsing error.
 */
public class ErrorExceptionThrower extends DefaultErrorStrategy {
    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        throw new RuntimeException(e);
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        throw new RuntimeException(new InputMismatchException(recognizer));
    }

    @Override
    public void sync(Parser recognizer) throws RecognitionException {
    }
}