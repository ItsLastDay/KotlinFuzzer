import kotlin.reflect.KTypeProjection
import kotlin.test.assertEquals
fun string(): String = null!!
class Fourple<A, B, C, D>
fun projections(): Fourple<String, in String, out String, * > = null!!
fun box(): String {
val string = ::string.returnType
assertEquals(listOf(string, string, string, null), (when {
(::projections) in null -> (::projections)
else -> (::projections)
}).returnType.arguments.map(KTypeProjection::type))
return "OK"
}