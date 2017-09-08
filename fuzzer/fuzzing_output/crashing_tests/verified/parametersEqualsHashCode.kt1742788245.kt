import kotlin.test.*
class A {
fun foo(s: String, x: Int): Unit {

}
fun bar(x: Int): Unit {

}
val baz = 42
}
fun box(): (String)? {
assertNotEquals(A::foo.parameters[0], A::bar.parameters[0])
assertNotEquals(A::foo.parameters[0], A::baz.parameters[0])
assertNotEquals(A::foo.parameters[1], A::bar.parameters[1])
assertNotEquals(A::foo.parameters[1], A::foo.parameters[2])
assertNotEquals(A::bar.parameters[1], A::foo.parameters[2])
assertEquals(A::foo.parameters[0], A::foo.parameters[0])
assertEquals(A::foo.parameters[0].hashCode(), A::foo.parameters[0].hashCode())
assertEquals(A::foo.parameters[1], A::foo.parameters[1])
assertEquals(A::foo.parameters[1].hashCode(), A::foo.parameters[1].hashCode())
assertEquals(A::bar.parameters[0], (when {
(A::bar) in null -> (A::bar)
else -> (A::bar)
}).parameters[0])
assertEquals(A::bar.parameters[0].hashCode(), A::bar.parameters[0].hashCode())
return "OK"
}