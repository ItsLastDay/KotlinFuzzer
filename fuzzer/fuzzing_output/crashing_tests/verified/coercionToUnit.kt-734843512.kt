import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun <T> await(t: T): T = suspendCoroutineOrReturn((if (true) {
({c -> (c)!!.resume(t)
COROUTINE_SUSPENDED})
} else {
({c -> (c)!!.resume(t)
COROUTINE_SUSPENDED})
}))
fun builder(c: (() -> Unit)): (String)? {
var result = "fail"
c.startCoroutine(handleResultContinuation({result = "OK"}))
return result
}
var TRUE = true
var FALSE = false
fun box(): (String)? {
val r1 = builder({await(Unit)})
if (r1 != "OK") {
return "fail 1"
}
val r2 = builder({if (await(1) != 1) {
throw RuntimeException
}("fail1")
if (TRUE) {
return@builder
}})
if (r2 != "OK") {
return "fail 2"
}
val r3 = builder({if (await(1) != 1) {
throw RuntimeException
}("fail2")
if (FALSE) {
return@builder
}})
if (r3 != "OK") {
return "fail 3"
}
val r4 = builder({if (await(1) != 1) {
throw RuntimeException
}("fail3")
return@builder})
if ((when {
true -> (r4 != "OK")
else -> (r4 != "OK")
})) {
return "fail 4"
}
return builder({await(1)})
}