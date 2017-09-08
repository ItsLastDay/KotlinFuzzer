import kotlin.test.assertEquals
interface H<T> {
fun foo(): (T)?
}
interface A: H<A>



inline fun box(): String {
assertEquals("T?", (when {
(H<A>::foo) !in null -> (H<A>::foo)
else -> (H<A>::foo)
}).returnType.toString())
return "OK"
}