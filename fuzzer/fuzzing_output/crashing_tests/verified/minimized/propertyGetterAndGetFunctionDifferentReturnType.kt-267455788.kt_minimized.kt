data class Foo(val id: String) {

}
fun box(): (String)? {
return (when {
(Foo::id) in null -> (Foo::id)
else -> (Foo::id)
}).call(Foo("OK"))
}