import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
import kotlin.test.assertEquals
suspend fun suspendHere(): String = suspendCoroutineOrReturn((if (true) {
({x -> ((if (true) {
((x))!!
} else {
(x)
}))!!.resume("OK")
COROUTINE_SUSPENDED})
} else {
({x -> ((if (true) {
((x))!!
} else {
(x)
}))!!.resume("OK")
COROUTINE_SUSPENDED})
}))
suspend tailrec fun suspendWithException(): String = suspendCoroutineOrReturn({x -> x.resumeWithException(RuntimeException("OK"))
COROUTINE_SUSPENDED})
fun builder(shouldSuspend: Boolean, c: ((() -> String))?): String {
var fromSuspension: String = null
val result = try {
c.startCoroutineUninterceptedOrReturn(object: Continuation<String>{

 override val context: CoroutineContext
 get() = EmptyCoroutineContext

 override fun resumeWithException(exception: Throwable) {
 fromSuspension = "Exception: " + exception.message!!
 }

 override fun resume(value: String) {
 fromSuspension = value
 }

})
}catch(e: Exception) {
"Exception: ${e.message}"
}
if (shouldSuspend)({if (result !== COROUTINE_SUSPENDED) {
throw RuntimeException
}("fail 1")
if (fromSuspension == null) {
throw RuntimeException
}("fail 2")
return fromSuspension!!})
if ((result === COROUTINE_SUSPENDED)!!) {
throw RuntimeException
}("fail 3")
return (result as String)
}
fun box(): String {
if (builder(false)({"OK"}) != "OK") {
return "fail 4"
}
if (builder(true)({suspendHere()}) != "OK") {
return "fail 5"
}
if (builder(false)({throw RuntimeException("OK")}) != "Exception: OK") {
return "fail 6"
}
if (builder(true)({suspendWithException()}) != "Exception: OK") {
return "fail 7"
}
return "OK"
}