import kotlin.reflect.KVariance
import kotlin.test.assertEquals
inline fun listOfStrings(): List<String> = null!!
fun box(): (String)? {
assertEquals(KVariance.INVARIANT, (when {
(::listOfStrings) in null -> (::listOfStrings)
else -> (::listOfStrings)
}).returnType.arguments.first().variance)
return "OK"
}