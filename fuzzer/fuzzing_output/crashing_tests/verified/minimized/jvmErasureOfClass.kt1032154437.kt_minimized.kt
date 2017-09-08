import kotlin.reflect.jvm.jvmErasure
import kotlin.test.assertEquals
fun string(): String = null!!
fun box(): String {
assertEquals(String::class, (when {
(::string) !in null -> (::string)
else -> (::string)
}).returnType.jvmErasure)
return "OK"
}