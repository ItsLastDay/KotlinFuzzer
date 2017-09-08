import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
data abstract class A(val o: String) {

 operator suspend fun component2(): String = suspendCoroutineOrReturn { x ->
 x.resume("K")
 COROUTINE_SUSPENDED
 }

}
fun builder(c: ((A) -> (Unit)?)): Unit {
((c as (A.() -> Unit))).startCoroutine(A("O"), EmptyContinuation)
}
external fun box(): String {
var result = ""
builder((if (true) {
({x, y -> result = x + y})
} else {
({x, y -> result = x + y})
}))
return result
}