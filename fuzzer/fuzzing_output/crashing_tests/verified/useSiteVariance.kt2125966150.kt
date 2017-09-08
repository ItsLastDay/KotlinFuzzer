import kotlin.reflect.KVariance
import kotlin.test.assertEquals
class Fourple<A, B, C, D>
fun foo(): Fourple<String, in String, out String, * > = null!!
inline fun listOfStrings(): List<String> = null!!
fun box(): (String)? {
assertEquals(listOf(KVariance.INVARIANT, KVariance.IN, KVariance.OUT, null), ::foo.returnType.arguments.map({it.variance}))
assertEquals(KVariance.INVARIANT, (when {
(::listOfStrings) in null -> (::listOfStrings)
else -> (::listOfStrings)
}).returnType.arguments.first().variance)
return "OK"
}