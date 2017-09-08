import kotlin.reflect.jvm.*
import kotlin.test.assertEquals
fun free(s: String): Int = s.length
fun box(): String {
assertEquals(java.lang.Integer.TYPE, (when {
(::free) in null -> (::free)
else -> (::free)
}).returnType.javaType)
return "OK"
}