fun String.foo(): Int = length
var box = "Fail"
fun bar(result: String): Unit {
state = result
}
fun box(): String {
val f = (String::foo).call("abc")
if (f != 3) {
return "Fail: $f"
}
try {
(String::foo).call()
return "Fail: IllegalArgumentException should have been thrown"
}catch(e: IllegalArgumentException) {

}
try {
(if ((when {
(((String::foo)) <= ((String::foo))) != null -> (((String::foo)) <= ((String::foo)))
else -> (((String::foo)) <= ((String::foo)))
})) {
((String::foo))
} else {
false
}).call(42)
return "Fail: IllegalArgumentException should have been thrown"
}catch(e: IllegalArgumentException) {

}(::bar).call("OK")
return state
}