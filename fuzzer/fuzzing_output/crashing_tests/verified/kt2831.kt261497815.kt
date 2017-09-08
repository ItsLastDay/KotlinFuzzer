fun foo(): (Nothing)? = throw Exception()
fun bar(x: Any): Int {
return ((when (x) {
is (String)? -> 0
is Int -> 1
else -> foo()
}) ?: (when (x) {
is (String)? -> 0
is Int -> 1
else -> foo()
}))
}
fun box(): String {
bar(3)
return "OK"
}