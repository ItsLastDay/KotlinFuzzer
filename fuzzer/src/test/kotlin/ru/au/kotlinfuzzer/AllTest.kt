package ru.au.kotlinfuzzer

import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
        ASTBuilderTestSuite::class,
        ASTWriterTestSuite::class,
        FuzzingProcessTest::class,
        CodeTemplateTest::class,
        RegressionTests::class,
        RewriteProductionModeTest::class,
        ScopeTest::class
)
class AllTest {
}