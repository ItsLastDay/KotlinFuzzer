class A {
inner class Inner {

}
}
fun A.foo() = (A::Inner)(this).o + ((if ((A::Inner) in (A::Inner)) {
(A::Inner)
} else {

}))(this).k