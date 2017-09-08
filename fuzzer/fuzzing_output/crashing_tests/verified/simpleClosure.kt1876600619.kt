fun box(): String {
val result = "OK"
fun Double.foo() = result
return ((if (true) {
((::foo)!!)
} else {
(::foo)
}))()
}