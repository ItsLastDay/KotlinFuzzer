package ru.au.kotlinfuzzer.fuzzing

import org.apache.logging.log4j.LogManager
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.jetbrains.kotlin.config.Services
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

// Large portions of code taken from
// https://github.com/JetBrains/kotlin/blob/master/compiler/daemon/daemon-client/src/org/jetbrains/kotlin/daemon/client/KotlinCompilerClient.kt
// https://github.com/JetBrains/kotlin/blob/master/compiler/daemon/src/org/jetbrains/kotlin/daemon/CompileServiceImpl.kt

private val logger = LogManager.getLogger()
private val threadPool = Executors.newCachedThreadPool()

// This property either points to kotlin-stdlib-....jar or to maven-packaged jar.
private val jarFile = Unit::class.java.protectionDomain.codeSource.location.toString()

fun invokeKotlinc(writtenFile: File, getCompileErrors: Boolean = false, myCp: String? = null): KotlincInvokeStatus {
    val args = "${writtenFile.absolutePath} -nowarn -cp ${if (myCp != null) myCp else jarFile} -d ./fuzzing_output/compiler_output/".split(" ")

    val compiler = K2JVMCompiler()
    val compilerArgs = K2JVMCompilerArguments().apply { K2JVMCompiler().parseArguments(args.toTypedArray(), this) }
    val services = Services.EMPTY
    val msgCollector = object : MessageCollector {
        var hasException = false
        var hasCompileError = false
        var crashMessages = mutableListOf<String>()
        var compileErrorMessages = mutableListOf<String>()

        override fun clear() {
            hasException = false
            hasCompileError = false
            crashMessages.clear()
            compileErrorMessages.clear()
        }

        override fun hasErrors(): Boolean {
            return hasException
        }

        override fun report(severity: CompilerMessageSeverity, message: String, location: CompilerMessageLocation?) {
            if (severity == CompilerMessageSeverity.EXCEPTION) {
                hasException = true
                crashMessages.add(message)
            }
            if (severity == CompilerMessageSeverity.ERROR) {
                hasCompileError = true
                if (getCompileErrors) {
                    val path = location?.let { "${it.line}:${it.column} ${it.lineContent}\n" } ?: ""
                    compileErrorMessages.add(path + message)
                }
            }
        }

    }

    logger.info("Running kotlinc on file ${writtenFile.name}")

    val futureExitCode = threadPool.submit {
        compiler.exec(msgCollector, services, compilerArgs)
    }
    var hasTimeout = false
    try {
        futureExitCode.get(TIMEOUT_MIN, TimeUnit.MINUTES)
    } catch(ex: TimeoutException) {
        hasTimeout = true
    }

    return KotlincInvokeStatus(msgCollector.crashMessages.joinToString("\n") +
            msgCollector.compileErrorMessages.joinToString("\n"),
            !msgCollector.hasCompileError,
            msgCollector.hasException,
            hasTimeout)
}
