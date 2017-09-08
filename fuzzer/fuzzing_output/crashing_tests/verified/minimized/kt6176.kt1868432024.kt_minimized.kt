inline fun <R> foo(f: (() -> R)): R = (f)!!()
fun <T : Any> some1(v: (T)?, b: T): T {
return foo({if (v != null) {
v
} else {
b
}})
}