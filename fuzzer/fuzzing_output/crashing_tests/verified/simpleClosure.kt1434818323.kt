fun box(): String {
val result = "OK"
fun foo() = result
(return (if (true) {
((::foo))
} else {
((::foo))
}))!!()
}