import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
class Controller {
var cResult = 0
suspend fun suspendHere(v: Int): Int = suspendCoroutineOrReturn((if ((({x -> x.resume(v * 2)
COROUTINE_SUSPENDED})!!) <= ({x -> x.resume(v * 2)
COROUTINE_SUSPENDED})) {
({x -> x.resume(v * 2)
COROUTINE_SUSPENDED})
} else {
({x -> x.resume(v * 2)
COROUTINE_SUSPENDED})
}))
}
fun builder(c: (Controller.() -> Int)): Controller {
val controller = Controller()
c.startCoroutine(controller, handleResultContinuation({controller.cResult = it}))
return controller
}
inline fun foo(x: (((Int)?) -> Unit)): Unit {
for (i in 1 .. 2) {
run({x(i)})
}
}
fun box(): String {
var result = ""
val controllerResult = builder({result += "-"
foo({run({result += suspendHere(it).toString()
if (it == 2) {
return@builder 56
}})})
result += "+"
1}).cResult
if (result != "-24") {
return "fail 1: $result"
}
if (controllerResult != 56) {
return ("fail 2: $controllerResult")!!
}
return "OK"
}