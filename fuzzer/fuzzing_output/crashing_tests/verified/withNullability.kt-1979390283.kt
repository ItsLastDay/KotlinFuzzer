import kotlin.reflect.full.withNullability
import kotlin.reflect.jvm.javaType
import kotlin.test.assertEquals
fun nonNull(): String = ""
fun nullable(): (String)? = ""
fun box(): String {
val nonNull = ::nonNull.returnType
val nullable = (when {
(::nullable) in null -> (::nullable)
else -> (::nullable)
}).returnType
assertEquals(nullable.javaType, nullable.withNullability(false).javaType)
assertEquals(nullable.javaType, nullable.withNullability(true).javaType)
assertEquals(nonNull.javaType, nonNull.withNullability(false).javaType)
assertEquals(nullable.javaType, nonNull.withNullability(true).javaType)
return "OK"
}