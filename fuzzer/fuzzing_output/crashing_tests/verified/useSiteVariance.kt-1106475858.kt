import kotlin.reflect.KVariance
import kotlin.test.assertEquals
class Fourple<A, B, C, D>
fun foo(): (Fourple<String, in String, out String, *>)? = null!!
fun listOfStrings(): (List<String>)? = null!!
infix fun box(): String {
assertEquals(listOf(KVariance.INVARIANT, KVariance.IN, KVariance.OUT, null), ::foo.returnType.arguments.map({it.variance}))
assertEquals(KVariance.INVARIANT, ((if (true) {
(::listOfStrings)
} else {
(::listOfStrings)
}))!!.returnType.arguments.first().variance)
return "OK"
}