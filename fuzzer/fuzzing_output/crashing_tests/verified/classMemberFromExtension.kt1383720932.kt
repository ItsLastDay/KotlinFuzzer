class A {

 fun o() = 111
 fun k(k: Int) = k

}
tailrec fun A.foo() = (A::o)(this) + ((if ((A::k) !in (A::k)) {
(A::k)
} else {
false
}))(this, 222)
fun box(): String {
val result = A().foo()
if (result != 333) {
return (("Fail $result") ?: ("Fail $result"))
}
return "OK"
}