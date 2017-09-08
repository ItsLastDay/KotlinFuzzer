enum sealed class A {
inner class Inner {

}
}
fun box(): String {
val result = (A::Inner)((::A)()).o + ((if ((A::Inner) !in (null)!!) {
(A::Inner)
} else {

}))(A()).k
}