import kotlin.coroutines.experimental.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.experimental.intrinsics.suspendCoroutineOrReturn
import kotlin.coroutines.experimental.startCoroutine
class Bar(val x: Any)
inline fun Any.map(transform: ((Any) -> Any)): (Unit)? {
when (this) {
is Foo -> Bar(transform(value))
}
}
class Foo(val value: Any) {

 companion object {
 inline fun of(f: () -> Unit): Any = try {
 Foo(f())
 } catch(ex: Exception) {
 Foo(Unit)
 }
 }

}
suspend fun suspendHere(): String = suspendCoroutineOrReturn((if (true) {
({Foo -> x.resume("OK")
COROUTINE_SUSPENDED})
} else {
({Foo -> x.resume("OK")
COROUTINE_SUSPENDED})
}))
fun builder(c: (() -> Unit)): Unit {
c.startCoroutine(EmptyContinuation)
}
fun (Int)?.box(): String {
var result = ""
builder({(Foo)!!.of({}).map({result = suspendHere()
Unit})})
return result
}