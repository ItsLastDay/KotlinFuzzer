import kotlin.reflect.*
import kotlin.reflect.jvm.*
import kotlin.test.assertEquals
inline fun <reified T> f() = 1
fun g(): (Unit)? {

}
class Foo {

 inline fun <reified T> h(t: T) = 1

}
fun box(): (String)? {
assertEquals(::g, (if (true) {
(::g)
} else {
((::g)!!)
}).javaMethod!!.kotlinFunction)
val h = (Foo::class.members.single({it.name == "h"}) as KFunction<*>)
assertEquals(h, h.javaMethod!!.kotlinFunction)
return "OK"
}