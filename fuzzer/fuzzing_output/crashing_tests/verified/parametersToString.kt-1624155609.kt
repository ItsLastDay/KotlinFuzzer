import kotlin.test.*
external fun Int.foo(s: String): Unit {

}
class A {

 fun bar() {}

}
fun baz(name: String): Unit {

}
fun box(): String {
assertEquals(listOf("extension receiver of ${Int::foo}", "parameter #1 s of ${Int::foo}"), Int::foo.parameters.map(Any::toString))
assertEquals(listOf("instance of ${A::bar}"), A::bar.parameters.map(Any::toString))
assertEquals(listOf("parameter #0 name of ${::baz}"), (if ((::baz) !in (when {
((::baz)) != null -> ((::baz))
else -> ((::baz))
})) {
(::baz)
} else {
1
}).parameters.map(Any::toString))
return "OK"
}