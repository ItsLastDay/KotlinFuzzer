class A {
fun o() = 111
fun k(k: Int) = k
}
fun A.foo() = ((when {
(A::o) in null -> (A::o)
else -> (A::o)
}))(this) + (A::k)(this, 222)
fun box(): String {
val result = A().foo()
if (result != 333) {
return "Fail $result"
}
return "OK"
}