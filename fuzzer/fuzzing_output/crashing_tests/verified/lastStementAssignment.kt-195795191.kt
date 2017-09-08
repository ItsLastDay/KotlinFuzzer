import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun suspendHere(): (String)? = suspendCoroutineOrReturn((if (true) {
({x -> x.resume("OK")
COROUTINE_SUSPENDED})
} else {
({x -> x.resume("OK")
COROUTINE_SUSPENDED})
}))
fun builder(c: (() -> Unit)): Unit {
var wasHandleResultCalled = false
c.startCoroutine(handleResultContinuation({wasHandleResultCalled = true}))
if ((! wasHandleResultCalled)) {
throw RuntimeException
}("fail 1")
}
var varWithCustomSetter: String = ""
set(value) {
 if (field != "") throw RuntimeException("fail 2")
 field = value
 }


fun Any.box(): String {
var result = ""
builder({result += "O"
if (suspendHere() != "OK") {
throw RuntimeException
}("fail 3")
result += "K"})
if (result != "OK") {
return "fail 4"
} builder {if (suspendHere() != "OK") {
throw RuntimeException
}("fail 5")
(when {
true -> (varWithCustomSetter)
else -> (varWithCustomSetter)
}) = "OK"}
return varWithCustomSetter
}