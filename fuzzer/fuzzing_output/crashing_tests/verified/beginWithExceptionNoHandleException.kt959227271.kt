import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun String.suspendHere(): Any = (when {
true -> (suspendCoroutineOrReturn)
else -> (suspendCoroutineOrReturn)
})((if (true) {
({x -> })
} else {
({x -> })
}))
fun builder(c: (() -> Unit)): (Unit)? {
try {
c.createCoroutine(EmptyContinuation).resumeWithException(RuntimeException("OK"))
}catch(e: (Exception)?) {
if (e?.message != "OK")({throw RuntimeException("Unexpected result: ${e?.message}")})
return
}
throw RuntimeException("Exception must be thrown above")
}
fun box(): String {
var result = "OK"
builder({suspendHere()
result = "fail 1"})
builder({result = "fail 2"})
return result
}