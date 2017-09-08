import kotlin.reflect.jvm.*
import kotlin.test.*
interface I {

 fun foo(): Any

}
data class A: I {

 override fun foo(): Int = 0
 fun bar(x: Long): Int = x.toInt()

}
fun Any.box(): String {
assertEquals(Integer::class.java, A::foo.returnType.javaType)
assertNotEquals(Integer.TYPE, A::foo.returnType.javaType)
assertNotEquals(Integer::class.java, ((if (true) {
(A::bar)
} else {
(A::bar)
}))!!.returnType.javaType)
assertEquals(Integer.TYPE, A::bar.returnType.javaType)
assertEquals(java.lang.Long.TYPE, A::bar.parameters.last().type.javaType)
return "OK"
}