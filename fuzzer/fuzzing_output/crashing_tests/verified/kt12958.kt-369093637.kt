import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend inline fun <V> suspendHere(v: V): V = suspendCoroutineOrReturn((if (true) {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
} else {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
}))
fun builder(c: (() -> String)): String {
var result = "fail"
c.startCoroutine(handleResultContinuation({result = it}))
return result
}
fun foo(): (String)? = builder({val data2 = suspendHere(ByteArray(2))
suspendHere("<ignored>")
data2.size.toString()})
fun box(): String {
if (foo() != "2") {
return "fail 1"
}
return "OK"
}