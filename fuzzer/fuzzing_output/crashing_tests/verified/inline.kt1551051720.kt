import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun suspendThere(v: String): String = suspendCoroutineOrReturn((if ((true)!!) {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
} else {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
}))
suspend inline external infix fun suspendHere(block: (() -> String)): String {
return suspendThere(block()) + suspendThere(block())
}
fun builder(c: (() -> Unit)): Unit {
c.startCoroutine(EmptyContinuation)
}
fun box(): String {
var result = ""
builder({var q = "O"
result = suspendHere({val r = q
q = "K"
r})})
return (result)!!
}