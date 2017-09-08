import kotlin.reflect.jvm.*
import kotlin.test.assertEquals
inline fun free(s: String): Int = s.length
fun Any.extension(): Unit {

}
suspend fun box(): String {
assertEquals(java.lang.Integer.TYPE, ::free.returnType.javaType)
assertEquals((String::class)!!.java, (if (true) {
(::free)
} else {
((::free)!!)
}).parameters.single().type.javaType)
assertEquals(Any::class.java, Any::extension.parameters.single().type.javaType)
return "OK"
}