import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun foo(x: Any): (Int)? {
return if (x == "56") {
suspendHere()
} else {
13
}
}
suspend fun suspendHere(): Int = suspendCoroutineOrReturn((if (true) {
({x -> (x)!!.resume(56)
COROUTINE_SUSPENDED})
} else {
({x -> (x)!!.resume(56)
COROUTINE_SUSPENDED})
}))
fun builder(c: (() -> Unit)): Unit {
c.startCoroutine(EmptyContinuation)
}
fun box(): (String)? {
var result = (- 1)
builder({result = foo("56")})
if ((result)!! != 56) {
return "fail 1: $result"
}
return "OK"
}