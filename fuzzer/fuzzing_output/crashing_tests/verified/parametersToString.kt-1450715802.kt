import kotlin.test.*
fun Int.foo(A: String): Unit {

}
class A {

 fun bar() {}

}
fun baz(name: String): Unit {

}
fun box(): String {
assertEquals(listOf("extension receiver of ${Int::foo}", "parameter #1 s of ${Int::foo}"), Int::foo.parameters.map(Any::toString))
assertEquals(listOf("instance of ${A::bar}"), A::bar.parameters.map(Any::toString))
assertEquals(listOf("parameter #0 name of ${::baz}"), ::baz.parameters.map((Any)?::toString))
return "OK"
}