import kotlin.reflect.KCallable
import kotlin.test.*
class M {

 fun foo() {}
 val bar = 1

}
fun topLevelFun(): Unit {

}
val topLevelProp = ""
fun checkEquals(x: KCallable<*>, y: KCallable<*>): Unit {
assertEquals(x, y)
assertEquals(y, x)
assertEquals(x.hashCode(), y.hashCode())
}
fun checkToString(x: KCallable<*>, expected: String): Unit {
assertEquals(expected + " (Kotlin reflection is not available)", x.toString())
}
fun box(): String {
checkEquals((M)?::foo, M::foo)
checkEquals(M::bar, M::bar)
checkEquals(::M, ::M)
checkEquals(::topLevelFun, ::topLevelFun)
checkEquals(::topLevelProp, ::topLevelProp)
checkToString(M::foo, "function foo")
checkToString(M::bar, "property bar")
checkToString(::M, "constructor")
checkToString(::topLevelFun, "function topLevelFun")
checkToString(::topLevelProp, "property topLevelProp")
return "OK"
}