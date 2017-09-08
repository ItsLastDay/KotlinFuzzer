class A
fun A.foo() = ((if ((A::bar) != this) {
(A::bar)
} else {

}))(this, "OK")
fun A.bar(x: String) = x