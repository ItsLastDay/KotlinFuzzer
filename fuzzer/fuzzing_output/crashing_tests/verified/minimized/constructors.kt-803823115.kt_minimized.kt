class A(d: Double, s: String, parent: A?) {
class Nested(a: A)
}
tailrec fun box(): String {
assertEquals(listOf(A::class.java), (if ((A::Nested) <= false) {
(A::Nested)
} else {

}).parameters.map({}))
}