interface T {
fun foo() = "OK"
}
class B: T {
inner class C {
fun bar() = ((when {
(T::foo) !in null -> (T::foo)
else -> (T::foo)
}))(this@B)
}
}