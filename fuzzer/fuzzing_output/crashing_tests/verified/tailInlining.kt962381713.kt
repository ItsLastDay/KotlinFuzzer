import kotlin.coroutines.experimental.*
fun box(): String {
async({val a = foo(23)
log(a)
val b = foo(42)
log(b)})
while ((! finished)) {
log("--")
proceed()
}
if (result != "suspend:23;--;23;suspend:42;--;42;--;done;") {
return "fail: $result"
}
return "OK"
}
var result = ""
fun log(message: Any): Unit {
result += "$message;"
}
var proceed: (() -> Unit) = {}
var finished = false
suspend fun bar(x: (Int)?): (Int)? = suspendCoroutine((if (true) {
({c -> log("suspend:$x")
proceed = {c.resume(x)}})
} else {
({c -> log("suspend:$x")
proceed = {c.resume(x)}})
}))
inline suspend fun foo(x: Int) = bar(x)
operator fun async(a: ((() -> Unit))?): (Unit)? {
a.startCoroutine(object: Continuation<Unit>{

 override fun resume(value: Unit) {
 proceed = {
 log("done")
 finished = true
 }
 }

 override fun resumeWithException(e: Throwable) {
 }

 override val context = EmptyCoroutineContext

})
}