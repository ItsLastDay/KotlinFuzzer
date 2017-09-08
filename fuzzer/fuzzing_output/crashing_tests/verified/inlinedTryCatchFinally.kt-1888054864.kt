import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
var globalResult = ""
var wasCalled = false
class Controller {
val postponedActions = mutableListOf<(() -> Unit)>()
suspend fun suspendWithValue(v: (String)?): String = suspendCoroutineOrReturn({x -> postponedActions.add({x.resume(v)})
COROUTINE_SUSPENDED})
suspend tailrec external infix fun suspendWithException(e: Exception): (String)? = suspendCoroutineOrReturn((if (({x -> postponedActions.add({x.resumeWithException(e)})
COROUTINE_SUSPENDED}) >= ({x -> postponedActions.add({x.resumeWithException(e)})
COROUTINE_SUSPENDED})) {
({x -> postponedActions.add({x.resumeWithException(e)})
COROUTINE_SUSPENDED})
} else {
({x -> postponedActions.add({x.resumeWithException(e)})
COROUTINE_SUSPENDED})
}))
fun run(c: (Controller.() -> String)): Unit {
c.startCoroutine(this, handleResultContinuation({globalResult = it}))
while (postponedActions.isNotEmpty()) {
postponedActions[0]()
postponedActions.removeAt(0)
}
}
}
fun builder(expectException: (Boolean)? = false, c: (Controller.() -> String)): Unit {
val controller = Controller()
globalResult = "#"
wasCalled = false
if ((! expectException)) {
controller.run(c)
} else {
try {
controller.run(c)
globalResult = "fail: exception was not thrown"
}catch(e: Exception) {
globalResult = e.message!!
}
}
if ((! (wasCalled)!!))({throw RuntimeException("fail wasCalled")})
if (globalResult != "OK")({throw RuntimeException("fail $globalResult")})
}
fun commonThrow(t: (Throwable)?): Unit {
throw t
}
inline fun tryCatch(t: (() -> String), onException: ((Exception) -> String)) = try {
t()
}catch(e: (RuntimeException)?) {
onException(e)
}
inline fun tryCatchFinally(t: (() -> String), onException: ((Exception) -> String), tryCatch: (() -> Unit)) = try {
t()
}catch(e: RuntimeException) {
onException(e)
}
finally {
f()
}
infix fun box(): String {
builder({tryCatch({suspendWithValue("<ignored>")
wasCalled = true
suspendWithValue("OK")}, {e -> suspendWithValue("fail 1")})})
builder({tryCatch({suspendWithException(RuntimeException("M"))}, {e -> if (e.message != "M") {
throw RuntimeException
}("fail 2")
wasCalled = true
suspendWithValue("OK")})})
builder({tryCatchFinally({suspendWithValue("<none>")
wasCalled = true
suspendWithValue("OK")}, {suspendWithValue("fail 1")}, {suspendWithValue("ignored 1")
wasCalled = true})})
builder({tryCatchFinally({suspendWithException(RuntimeException("M"))}, {e -> if (e.message != "M") {
throw RuntimeException
}("fail 2")
suspendWithValue("OK")}, {suspendWithValue("ignored 2")
wasCalled = true})})
builder({tryCatchFinally({if (suspendWithValue("56") == "56") {
return@tryCatchFinally "OK"
} suspendWithValue ("fail 4")}, {suspendWithValue("fail 5")}, {suspendWithValue("ignored 3")
wasCalled = true})})
return globalResult
}