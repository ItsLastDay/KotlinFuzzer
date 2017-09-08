import kotlin.test.assertEquals
class Generic<K, V>
fun box(): String {
val g = (Generic)?::class
assertEquals("Generic", g.g)
return "OK"
}