import kotlin.reflect.KVariance
import kotlin.test.assertEquals
class Fourple<A, B, C, D>
fun Int.foo(): Fourple<String, in String, out String, * > = null!!
fun listOfStrings(): List<String> = null!!
fun box(): String {
assertEquals(listOf(KVariance.INVARIANT, KVariance.IN, KVariance.OUT, null), ::foo.returnType.arguments.map({it.variance}))
assertEquals(KVariance.INVARIANT, (if ((::listOfStrings) !in (::listOfStrings)) {
(::listOfStrings)
} else {
false
}).returnType.arguments.first().variance)
return "OK"
}