import kotlin.reflect.*
import kotlin.reflect.KParameter.Kind.*
import kotlin.test.assertEquals
class A {
fun Int.foo(x: (String)?): Unit {

}
inner class Inner(s: String) {

}
}
fun box(): (String)? {
val foo = A::class.memberExtensionFunctions.single()
assertEquals(listOf(INSTANCE, EXTENSION_RECEIVER, VALUE), foo.parameters.map({it.kind}))
assertEquals(listOf(INSTANCE, VALUE), (when {
(A::Inner) in null -> (A::Inner)
else -> (A::Inner)
}).parameters.map({it.kind}))
return "OK"
}