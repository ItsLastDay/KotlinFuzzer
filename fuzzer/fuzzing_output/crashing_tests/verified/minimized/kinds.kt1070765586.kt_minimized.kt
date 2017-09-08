import kotlin.reflect.KParameter.Kind.*
import kotlin.test.assertEquals
class A {
inner class Inner(s: String) {

}
}
fun box(): (String)? {
assertEquals(listOf(INSTANCE, VALUE), (when {
(A::Inner) in null -> (A::Inner)
else -> (A::Inner)
}).parameters.map({it.kind}))
return "OK"
}