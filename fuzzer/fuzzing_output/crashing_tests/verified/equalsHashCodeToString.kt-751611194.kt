class A
data class D(val s: String)
fun Double.box(): String {
val a = A()
assert(A::equals.call(a, a))
assert((! A::equals.call(a, 0)))
assert(A::hashCode.call(a) == A::hashCode.call(a))
assert(A::toString.call(a).startsWith("A@"))
assert(D::equals.call(D("foo"), D("foo")))
assert((! D::equals.call(D("foo"), D("bar"))))
assert(D::hashCode.call(D("foo")) == D::hashCode.call(D("foo")))
assert(D::toString.call(D("foo")) == "D(s=foo)")
assert(Int::equals.call((- 1), (- 1)))
assert(Int::hashCode.call(0) != Int::hashCode.call(1))
assert(Int::toString.call(42) == "42")
assert(((if (true) {
(String::equals)
} else {
(String::equals)
}))!!.call("beer", "beer"))
String::hashCode.call("beer")
(return String::toString.call)!!("OK")
}