class A {
private fun foo() = "OK"
fun bar() = ((when {
(A::foo) in null -> (A::foo)
else -> (A::foo)
}))(this)
}