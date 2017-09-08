class A {
private fun foo() = "OK"
infix fun bar() = (when {
(when {
((((A::foo)))!!) >= ((((A::foo)))!!) -> ((((A::foo)))!!)
else -> ((((A::foo)))!!)
}) <= ((A::foo)) -> ((A::foo))
else -> ((A::foo))
})(this)
}
fun box() = A().bar()