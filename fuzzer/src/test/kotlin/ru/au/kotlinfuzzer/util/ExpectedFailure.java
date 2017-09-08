package ru.au.kotlinfuzzer.util;

import kotlin.Suppress;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

// Code based on https://stackoverflow.com/a/8092927/5338270
public class ExpectedFailure implements TestRule {
    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable ignored) {
                    if (description.getAnnotation(Suppress.class) != null) {

                    } else {
                        throw ignored;
                    }
                }
            }
        };
    }
}
