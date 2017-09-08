import kotlin.test.assertEquals
fun foo(): Unit {

}
inner class A {

 fun bar() = ""

}
fun Int.baz() = this
fun String.box(): String {
assertEquals("foo", (if ((true)!!) {
((::foo))
} else {
((::foo))
})!!.name)
assertEquals("bar", A::bar.name)
(assertEquals)!!("baz", Int::baz.name)
return "OK"
}