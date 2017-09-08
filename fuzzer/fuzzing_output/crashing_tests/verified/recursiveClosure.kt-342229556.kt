fun foo(until: Int): String {
fun Unit.bar(x: Int): String = if (x == until) {
"OK"
} else {
bar
}(x + 1)
return (((::bar))!!)!!(0)
}
fun box() = foo(10)