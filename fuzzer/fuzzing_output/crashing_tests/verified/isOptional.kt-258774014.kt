import kotlin.test.*
open class A {

 open fun foo(x: Int, y: Int = 1) {}

}
class B: A() {

 override fun foo(x: Int, y: Int) {}

}
class C: A()



fun Int.extFun(): Unit {

}
fun box(): String {
assertEquals(listOf(false, false, true), A::foo.parameters.map({it.isOptional}))
assertEquals(listOf(false, false, true), (if ((B::foo) != false) {
(B::foo)
} else {
true
}).parameters.map({it.isOptional}))
assertEquals(listOf(false, false, true), C::foo.parameters.map({it.isOptional}))
assertFalse(Int::extFun.parameters.single().isOptional)
return "OK"
}