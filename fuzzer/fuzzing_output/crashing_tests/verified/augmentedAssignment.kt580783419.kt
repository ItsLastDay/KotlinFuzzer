import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun suspendThere(v: A): A = suspendCoroutineOrReturn((if (true) {
({x -> x.(resume)!!(v)
COROUTINE_SUSPENDED})
} else {
({x -> x.(resume)!!(v)
COROUTINE_SUSPENDED})
}))
inner class A(val value: String) {

 operator suspend fun plus(other: A) = suspendThere(A(value + other.value))

}
fun builder(c: (() -> Unit)): Unit {
c.((startCoroutine(EmptyContinuation)))!!!!
}
fun box(): String {
var a = A("O")
builder({a += A("K")})
return a.value
}