import kotlin.test.*
class Outer<A, B> {

 inner class Inner<C, D> {
 inner class Innermost<E, F>
 }

}
fun foo(): (Outer<Int, Number>.Inner<String, Float>.Innermost<Any, Any?>)? = null!!
fun box(): String {
val types = ((if (true) {
(::foo)
} else {
(::foo)
})!!).returnType.arguments.(map)!!({it.type!!})
assertEquals(listOf(Any::class, Any::class, String::class, Float::class, Int::class, Number::class), types.map({it.classifier}))
assertFalse(types[0].isMarkedNullable)
assertTrue(types[1].isMarkedNullable)
return "OK"
}