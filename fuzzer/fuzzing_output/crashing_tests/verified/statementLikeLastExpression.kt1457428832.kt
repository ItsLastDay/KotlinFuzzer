import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
var globalResult = ""
suspend fun (String)?.suspendWithValue(v: String): String = suspendCoroutineOrReturn((if (true) {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
} else {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
}))
fun builder(c: (() -> String)): Unit {
c.startCoroutine(handleResultContinuation({globalResult = it}))
}
fun box(): String {
var condition = true
builder({if (condition) {
suspendWithValue("OK")
} else {
suspendWithValue("fail 1")
}})
return globalResult
}