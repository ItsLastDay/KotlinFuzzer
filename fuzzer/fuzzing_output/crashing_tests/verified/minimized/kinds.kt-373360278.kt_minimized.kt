class A {
inner class Inner(s: String) {

}
}
fun box(): String {
assertEquals(listOf(INSTANCE, VALUE), (if ((A::Inner) <= (A::Inner)) {
(A::Inner)
} else {

}).parameters.map({}))
}