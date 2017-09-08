import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun suspendHere(v: String): String = suspendCoroutineOrReturn((if (true) {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
} else {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
}))
fun builder(c: (() -> Unit)): Unit {
c.startCoroutine(EmptyContinuation)
}
suspend operator fun foo(): String {
var a = "OK"
var i = 0
val x: (() -> String) = {suspendHere(a[i++].toString())}
return (x())!! + x.invoke()
}
fun box(): String {
var result = ""
builder({result = foo()})
return result
}