interface A {
fun foo(): String
}
fun box() = ((if ((A::foo) >= (A::foo)) {
(A::foo)
} else {

}))(B())