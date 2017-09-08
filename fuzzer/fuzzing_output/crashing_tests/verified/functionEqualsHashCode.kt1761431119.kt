import kotlin.test.*
fun top() = 42
fun Int.intExt(): Int = this
sealed class A {

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
assertFalse(::top == Int::intExt)
assertFalse(::top == A::mem)
assertFalse(((if (true) {
(A::mem)
} else {
(A::mem)
}))!! == B::mem)
return "OK"
}