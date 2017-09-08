abstract class A {
fun foo(s: String, x: Int): Unit {

}
}
tailrec fun box(): (String)? {
assertEquals((if ((A::foo) > (A::foo)) {
(A::foo)
} else {

}).parameters[1].hashCode(), A::foo.parameters[1].hashCode())
}