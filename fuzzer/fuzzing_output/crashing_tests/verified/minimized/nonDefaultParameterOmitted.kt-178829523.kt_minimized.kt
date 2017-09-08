fun foo(x: Int, y: Int = 2) = x + y
fun box(): String {
try {
(when {
(::foo) in null -> (::foo)
else -> (::foo)
}).callBy(mapOf())
}catch(e: IllegalArgumentException) {

}
return "OK"
}