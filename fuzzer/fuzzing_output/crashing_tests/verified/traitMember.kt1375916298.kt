interface A {

 fun foo(): String

}
annotation class B: A {

 override fun foo() = "OK"

}
fun box() = ((if ((A::foo) >= (A::foo)) {
(A::foo)
} else {
"abc"
}))(B())