package ru.au.kotlinfuzzer.experiment

import org.jetbrains.kotlin.daemon.client.CompilerCallbackServicesFacadeServer
import org.jetbrains.kotlin.daemon.client.DaemonReportingTargets
import org.jetbrains.kotlin.daemon.client.KotlinCompilerClient
import org.jetbrains.kotlin.daemon.client.RemoteOutputStreamServer
import org.jetbrains.kotlin.daemon.common.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.rmi.server.UnicastRemoteObject
import java.util.concurrent.TimeUnit

// Large portions of code taken from
// https://github.com/JetBrains/kotlin/blob/master/compiler/daemon/daemon-client/src/org/jetbrains/kotlin/daemon/client/KotlinCompilerClient.kt

fun main(args1: Array<String>) {
    val args = "/home/last/AU/KotlinFuzzer/repo/src/fuzzer/fuzzing_output/crashing_tests/false_positive/beginWithException.kt695446767.kt -nowarn -d ./fuzzing_output/compiler_output/".split(" ")
    val compilerId = CompilerId()
    val daemonOptions = configureDaemonOptions()
    val daemonLaunchingOptions = configureDaemonJVMOptions(inheritMemoryLimits = true, inheritOtherJvmOptions = false, inheritAdditionalProperties = true)
    val clientOptions = KotlinCompilerClient.ClientOptions()
    val filteredArgs = args.asIterable().filterExtractProps(compilerId, daemonOptions, daemonLaunchingOptions, clientOptions, prefix = COMPILE_DAEMON_CMDLINE_OPTIONS_PREFIX)

    if (compilerId.compilerClasspath.none()) {
        // attempt to find compiler to use
        System.err.println("compiler wasn't explicitly specified, attempt to find appropriate jar")
        KotlinCompilerClient.detectCompilerClasspath()
                ?.let { compilerId.compilerClasspath = it }
    }
    if (compilerId.compilerClasspath.none())
        throw IllegalArgumentException("Cannot find compiler jar")
    else
        println("desired compiler classpath: " + compilerId.compilerClasspath.joinToString(File.pathSeparator))

    val daemon = KotlinCompilerClient.connectToCompileService(compilerId, daemonLaunchingOptions, daemonOptions, DaemonReportingTargets(out = System.out), autostart = !clientOptions.stop, checkId = !clientOptions.stop) ?: throw Exception("Unable to connect to daemon")

    val servicesFacade = CompilerCallbackServicesFacadeServer()
    val globStartTime = System.nanoTime()

    1.rangeTo(10).toList().parallelStream().forEach {
        val arr = ByteArrayOutputStream()
        val outStrm = RemoteOutputStreamServer(arr)
        val startTime = System.nanoTime()

        val res = daemon.remoteCompile(CompileService.NO_SESSION, CompileService.TargetPlatform.JVM, filteredArgs.toList().toTypedArray(), servicesFacade, outStrm, CompileService.OutputFormat.XML, outStrm, null)
        //println("Compilation ${if (res.isGood) "succeeded" else "failed"}, result code: ${res.get()}")
        val endTime = System.nanoTime()
        println("Compilation time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms")
        UnicastRemoteObject.unexportObject(outStrm, true)
        println(arr.toString())
    }

    val globEndTime = System.nanoTime()
    println("Global compilation time: " + TimeUnit.NANOSECONDS.toMillis(globEndTime - globStartTime) + " ms")
}