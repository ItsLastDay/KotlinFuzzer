fun baz(name: String): Unit {

}
fun box(): String {
assertEquals(listOf("parameter #0 name of ${::baz}"), (if ((::baz) !in (when {
((::baz)) != null -> ((::baz))
else -> ((::baz))
})) {
(::baz)
} else {

}).parameters.map(Any::toString))
}