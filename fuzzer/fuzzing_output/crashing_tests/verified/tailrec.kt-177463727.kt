import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
import kotlin.test.assertEquals
suspend fun (ArrayList<Int>)?.yield(v: Int): Unit = suspendCoroutineOrReturn((if ((try {
({x -> this.add(v)
x.resume(Unit)
COROUTINE_SUSPENDED})
}
finally {
({x -> this.add(v)
x.resume(Unit)
COROUTINE_SUSPENDED})
}) != null) {
({x -> this.add(v)
x.resume(Unit)
COROUTINE_SUSPENDED})
} else {
({x -> this.add(v)
x.resume(Unit)
COROUTINE_SUSPENDED})
}))
tailrec suspend fun ArrayList<Int>.fromTo(from: Int, to: Int): Unit {
if (from > to) {
return
} yield (from)
return fromTo(from + 1, to)
}
fun builder(c: (() -> Unit)): (Unit)? {
c.startCoroutine(EmptyContinuation)
}
fun box(): String {
val result = arrayListOf<Int>()
builder({result.fromTo(1, 5)})
assertEquals(listOf(1, 2, 3, 4, 5), result)
return "OK"
}