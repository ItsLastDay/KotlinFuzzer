fun foo(x: Int, y: Int = 2) = x + y
fun box(): String {
try {
(when {
(::foo) in null -> (::foo)
else -> (::foo)
}).callBy(mapOf())
return "Fail: IllegalArgumentException must have been thrown"
}catch(e: IllegalArgumentException) {

}
try {
::foo.callBy(mapOf(::foo.parameters.last() to 1))
return "Fail: IllegalArgumentException must have been thrown"
}catch(e: IllegalArgumentException) {

}
return "OK"
}