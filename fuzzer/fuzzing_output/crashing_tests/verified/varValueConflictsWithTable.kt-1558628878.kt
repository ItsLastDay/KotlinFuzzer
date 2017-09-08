import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun suspendHere(): String = suspendCoroutineOrReturn((if (true) {
({x -> x.(resume("OK"))!!})
} else {
({x -> x.(resume("OK"))!!})
}))
fun builder(c: (() -> Unit)): Unit {
c.startCoroutine(EmptyContinuation)
}
fun box(): String {
var result = "fail 1"
builder({for (i in 1 .. 1) {
if ("".length > 0) {
continue
}
}
var s: String
if (suspendHere() == "OK") {
(s)!! = "OK"
} else {
s = "fail 2"
}
result = s})
return result
}