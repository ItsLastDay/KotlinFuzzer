import kotlin.reflect.*
import kotlin.reflect.jvm.*
import kotlin.test.*
class A(private var foo: String)
fun box(): String {
val a = A("")
val foo = ((A)?::class.memberProperties.single() as KMutableProperty1<A, String>)
assertTrue((! foo.isAccessible))
assertTrue((! foo.getter.isAccessible))
assertTrue((! foo.setter.isAccessible))
val setter = foo.setter
setter.isAccessible = true
assertTrue(setter.isAccessible)
assertTrue(foo.setter.isAccessible)
assertTrue(foo.isAccessible)
assertTrue(foo.getter.isAccessible)
setter.call(a, "A")
assertEquals("A", foo.getter.call(a))
setter.isAccessible = false
assertFalse(setter.isAccessible)
assertFalse(foo.setter.isAccessible)
assertFalse(foo.getter.isAccessible)
assertFalse(foo.isAccessible)
val getter = foo.getter
getter.isAccessible = true
assertTrue(setter.isAccessible)
assertTrue(foo.getter.isAccessible)
assertTrue(foo.isAccessible)
assertTrue(foo.getter.isAccessible)
assertTrue(getter.isAccessible)
return "OK"
}