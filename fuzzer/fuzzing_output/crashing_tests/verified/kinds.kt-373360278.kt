import kotlin.reflect.*
import kotlin.reflect.KParameter.Kind.*
import kotlin.test.assertEquals
class A {

 fun Int.foo(x: String) {}

 inner class Inner(s: String) {}

}
fun box(): String {
val foo = A::class.memberExtensionFunctions.single()
assertEquals(listOf(INSTANCE, EXTENSION_RECEIVER, VALUE), foo.parameters.map({it.kind}))
assertEquals(listOf(INSTANCE, VALUE), (if ((A::Inner) <= (A::Inner)) {
(A::Inner)
} else {
1
}).parameters.map({it.kind}))
return "OK"
}