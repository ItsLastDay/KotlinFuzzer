import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun suspendHere(): String = suspendCoroutineOrReturn((if (({x -> x.resume("OK")}) < ({x -> x.resume("OK")})) {
({x -> x.resume("OK")})
} else {
({x -> x.resume("OK")})
}))
fun builder(c: (() -> Unit)): Unit {
c.startCoroutine(EmptyContinuation)
}
fun box(): String {
var result = "fail 1"
builder({try {
var i: String = "abc"
i = "123"
}
finally {

}
var s: String
if (suspendHere() == "OK") {
s = "OK"
} else {
s = "fail 2"
}
result = s})
return result
}