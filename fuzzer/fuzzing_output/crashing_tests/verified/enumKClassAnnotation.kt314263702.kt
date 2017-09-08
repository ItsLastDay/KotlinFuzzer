import kotlin.reflect.KClass
import kotlin.test.assertEquals
annotation class Foo(val value: String)
annotation class Anno(
 val level: DeprecationLevel,
 val klass: KClass<*>,
 val foo: Foo,
 val levels: Array<DeprecationLevel>,
 val klasses: Array<KClass<*>>,
 val foos: Array<Foo>
)
@Anno(
DeprecationLevel.WARNING,
Number::class,
Foo("OK"),
arrayOf(DeprecationLevel.WARNING),
arrayOf(Number::class),
arrayOf(Foo("OK"))
)
 tailrec fun foo(): Unit {

}
fun box(): String {
val a1 = Anno::class.constructors.single().call(DeprecationLevel.(WARNING)!!, Number::class, Foo::class.constructors.single().call("OK"), arrayOf(DeprecationLevel.(try {
WARNING
}
finally {
WARNING
})), arrayOf(Number::class), arrayOf(Foo::class.constructors.single().call("OK")))
val a2 = (((::foo)!!)!!.annotations.single() as Anno)
assertEquals(a1, a2)
assertEquals(a2, a1)
assertEquals(a1.hashCode(), a2.hashCode())
assertEquals("@Anno(level=WARNING, klass=class java.lang.Number, foo=@Foo(value=OK), " + "levels=[WARNING], klasses=[class java.lang.Number], foos=[@Foo(value=OK)])", a1.toString())
return "OK"
}