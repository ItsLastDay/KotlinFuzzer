import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
class X {

 var res = ""
 suspend fun execute() {
 a()
 b()
 }

 private suspend fun a() {
 res += suspendThere("O")
 res += suspendThere("K")
 }

 private suspend fun b() {
 res += suspendThere("5")
 res += suspendThere("6")
 }

}
suspend fun suspendThere(v: String): String = suspendCoroutineOrReturn((if (true) {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
} else {
({x -> x.resume(v)
COROUTINE_SUSPENDED})
}))
fun builder(c: (X.() -> Unit)): Unit {
c.startCoroutine(X(), EmptyContinuation)
}
fun box(): String {
var result = ""
builder({execute()
result = res})
if (result != "OK56") {
return "fail 1: $result"
}
return "OK"
}