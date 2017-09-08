import kotlin.reflect.jvm.*
enum class E
fun box(): String {
try {
val c = (E)?::class.constructors.single()
c.isAccessible = true
c.E()
return "Fail: constructing an enum class should not be allowed"
}catch(e: Throwable) {
return "OK"
}
}