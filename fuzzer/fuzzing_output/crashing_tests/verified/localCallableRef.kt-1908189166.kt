import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun suspendWithValue(result: (() -> (String)?)): String = suspendCoroutineOrReturn((if (true) {
({x -> x.resume(result())
COROUTINE_SUSPENDED})
} else {
({x -> x.resume(result())
COROUTINE_SUSPENDED})
}))
fun builder(c: ((() -> Unit))?): Unit {
c.startCoroutine(EmptyContinuation)
}
fun box(): String {
var result = ""
builder({fun ok() = "OK"
result = suspendWithValue(::ok)})
return result
}