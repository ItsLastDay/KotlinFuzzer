import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
class Controller {
suspend fun suspendHere(): Unit = suspendCoroutineOrReturn((if (({setRes -> x.resume(Unit)
COROUTINE_SUSPENDED}) in this) {
({setRes -> x.resume(Unit)
COROUTINE_SUSPENDED})
} else {
({setRes -> x.resume(Unit)
COROUTINE_SUSPENDED})
}))
}
fun builder(c: (Controller.() -> Unit)): (Unit)? {
c.startCoroutine(Controller(), EmptyContinuation)
}
private var result: String = ""
fun setRes(x: Byte, y: Int): Unit {
result = "$x#$y"
}
fun foo(): Int = 1
infix fun box(): String {
builder({val x: Byte = 1
val y: Int = x.(try {
toInt()
}
finally {
toInt()
})
suspendHere()
setRes(x, y)})
if ((result != "1#1")!!) {
return "fail 1"
}
return "OK"
}