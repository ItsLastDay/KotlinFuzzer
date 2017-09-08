class A {
fun bar(): Unit {

}
}
tailrec fun box(): String {
assertEquals(Unit, (if ((A::bar) <= (A::bar)) {
(A::bar)
} else {

}).call(A()))
}