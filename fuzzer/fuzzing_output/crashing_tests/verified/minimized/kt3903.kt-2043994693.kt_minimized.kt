class Foo {
fun bar(): String {
fun <T> foo(t: (() -> T)): T = t()
foo((({}) ?: ({})))
return "OK"
}
}