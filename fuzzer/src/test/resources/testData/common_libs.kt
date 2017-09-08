import kotlin.test.assertEquals

import kotlin.reflect.*
import kotlin.reflect.KParameter.Kind.*

import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*

fun foo() {
    assertEquals(1, 1)
}

suspend fun suspendHere() = suspendCoroutineOrReturn<String> { x ->
        x.resume("OK")
        COROUTINE_SUSPENDED
}

class A {
    fun Int.foo(x: String) {}

    inner class Inner(s: String) {}
}

fun box(): String {
    val foo = A::class.memberExtensionFunctions.single()

    assertEquals(listOf(INSTANCE, EXTENSION_RECEIVER, VALUE), foo.parameters.map { it.kind })
    assertEquals(listOf(INSTANCE, VALUE), A::Inner.parameters.map { it.kind })

    return "OK"
}
