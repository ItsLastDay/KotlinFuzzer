class A {
private fun foo() = "OK"
fun bar() = (if (((A::foo)) >= 1) {
((A::foo))
} else {
false
})(this)
}
fun box() = A().bar()