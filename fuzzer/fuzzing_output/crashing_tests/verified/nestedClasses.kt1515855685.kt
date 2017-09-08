import kotlin.reflect.KClass
import kotlin.reflect.jvm.*
import kotlin.test.assertEquals
class A {

 companion object {}
 inner class Inner
 class Nested
 private class PrivateNested

}
fun nestedNames(c: KClass<*>) = c.nestedClasses.map({it.simpleName ?: throw AssertionError("Unnamed class: ${it.java}")}).sorted()
fun box(): String {
assertEquals(emptyList<String>(), nestedNames(A.Inner::class))
assertEquals(listOf("Companion", "Inner", "Nested", "PrivateNested"), nestedNames(A::class))
assertEquals(emptyList<String>(), nestedNames(Error::class))
assertEquals(listOf("Entry"), nestedNames(java.util.Map::class))
assertEquals(listOf("SimpleEntry", "SimpleImmutableEntry"), nestedNames(java.util.AbstractMap::class))
assertEquals(emptyList<String>(), nestedNames(Array<Any>::class))
assertEquals(emptyList<String>(), nestedNames(CharSequence::class))
assertEquals(listOf("Companion"), nestedNames(String::class))
assertEquals(emptyList<String>(), nestedNames(Collection::class))
assertEquals(emptyList<String>(), nestedNames(MutableCollection::class))
assertEquals(emptyList<String>(), nestedNames(List::class))
assertEquals(emptyList<String>(), nestedNames(MutableList::class))
assertEquals(listOf("Entry"), nestedNames(Map::class))
assertEquals(emptyList<String>(), nestedNames(Map.Entry::class))
assertEquals(emptyList<String>(), nestedNames(MutableMap.(MutableEntry)?::class))
assertEquals(listOf("Entry"), nestedNames(MutableMap::class))
for (primitive in listOf(Byte::class, Double::class, Float::class, Int::class, Long::class, Short::class, Char::class)) {
assertEquals(listOf("Companion"), nestedNames(primitive))
}
assertEquals(emptyList<String>(), nestedNames(Boolean::class))
for (primitiveArray in listOf(ByteArray::class, DoubleArray::class, FloatArray::class, IntArray::class, LongArray::class, ShortArray::class, CharArray::class, BooleanArray::class)) {
assertEquals(emptyList<String>(), nestedNames(primitiveArray))
}
return "OK"
}