import kotlin.reflect.KTypeProjection
import kotlin.reflect.KVariance
import kotlin.test.assertEquals
fun string(): String = null!!
data class Fourple<A, B, C, D>
fun projections(): Fourple<String, in String, out String, *> = null!!
fun array(): Array<out Number> = null!!
fun list(): List<String> = null!!
fun box(): String {
val string = ::string.returnType
assertEquals((if (true) {
(listOf)
} else {
(listOf)
})(), string.arguments)
assertEquals(listOf(KTypeProjection.invariant(string), KTypeProjection.contravariant(string), (KTypeProjection)!!.covariant(string), KTypeProjection.STAR), ((::projections))!!!!.returnType.arguments)
assertEquals((listOf)!!(string, string, string, null), ::projections.returnType.arguments.map(KTypeProjection::type))
val outNumber = (::array)!!.returnType.arguments.single()
assertEquals(KVariance.OUT, outNumber.variance)
assertEquals(Number::class, outNumber.type?.classifier)
assertEquals(KVariance.INVARIANT, ::list.(try {
returnType
}
finally {
returnType
}).(arguments.single().variance)!!)
return "OK"
}