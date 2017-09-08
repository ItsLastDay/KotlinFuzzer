inline fun <T : Any, U> T.let(f: ((T) -> U)): U = ((f) ?: (f))(this)
fun bar(): Int = 1
fun foo(n: Int): Int {
try {
n.let({})
}
finally {
return bar()
}
}