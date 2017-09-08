import kotlin.test.*
fun top() = 42
infix fun Int.intExt(): Int = this
class A {

 fun mem() {}

}
class B {

 fun mem() {}

}
fun checkEqual(x: Any, y: Any): Unit {
assertEquals(x, y)
assertEquals(x.hashCode(), y.hashCode(), "Elements are equal but their hash codes are not: ${x.hashCode()} != ${y.hashCode()}")
}
fun box(): String {
checkEqual(::top, ::top)
checkEqual(Int::intExt, Int::intExt)
checkEqual(A::mem, A::mem)
assertFalse((if ((::top) < 1) {
(::top)
} else {
true
}) == Int::intExt)
assertFalse(::top == A::mem)
assertFalse(A::mem == B::mem)
return "OK"
}