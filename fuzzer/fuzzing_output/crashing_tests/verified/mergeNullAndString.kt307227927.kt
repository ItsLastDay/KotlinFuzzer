import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
fun builder(c: (() -> Unit)): Unit {
c.startCoroutine(EmptyContinuation)
}
var res = ""
suspend fun foo(y: (A)?): (String)? {
val origin: (String)? = y?.z
if (origin != null)({baz(origin)
baz(origin)})
return res
}
suspend operator fun baz(y: String): Unit = suspendCoroutineOrReturn((if (true) {
({x -> res += y[res.length]
x.resume(Unit)
COROUTINE_SUSPENDED})
} else {
({x -> res += y[res.length]
x.resume(Unit)
COROUTINE_SUSPENDED})
}))
class A(val z: String)
fun box(): String {
var result = ""
builder({result = (foo(A("OK")))!!})
return result
}