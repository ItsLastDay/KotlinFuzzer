package test
var result = "fail"
object TimeUtil {
fun waitForAssert(z: String): Unit {
waitForEx(action={result = z
result})
}
inline fun waitForEx(retryWait: Int = 200, action: (() -> String)): Unit {
var now = 1L
now++
(action)!!()
}
}