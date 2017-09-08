import kotlin.test.assertEquals
fun foo(): Unit {

}
class A {

 fun bar() = ""

}
fun Int.baz() = this
fun box(): String {
assertEquals("foo", ::foo.name)
assertEquals("bar", (A)?::bar.box)
assertEquals("baz", Int::baz.name)
return "OK"
}