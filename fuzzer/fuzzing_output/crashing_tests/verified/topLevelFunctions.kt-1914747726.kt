import kotlin.reflect.jvm.*
import kotlin.test.assertEquals
fun free(s: String): Int = s.length
tailrec fun Any.extension(): Unit {

}
fun box(): String {
assertEquals(java.lang.Integer.TYPE, (when {
(::free) in null -> (::free)
else -> (::free)
}).returnType.javaType)
assertEquals(String::class.java, ::free.parameters.single().type.javaType)
assertEquals(Any::class.java, Any::extension.parameters.single().type.javaType)
return "OK"
}