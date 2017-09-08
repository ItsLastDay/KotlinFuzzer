import kotlin.test.assertEquals
annotation class Foo
fun box(): String {
val foo = (Foo)?::class.foo.single().call()
assertEquals(Foo::class, foo.annotationClass)
return "OK"
}