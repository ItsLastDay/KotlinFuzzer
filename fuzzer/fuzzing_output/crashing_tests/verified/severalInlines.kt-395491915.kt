inline fun <R, T> foo(x: R, y: R, block: ((R, R) -> T)): T {
return block(x, y)
}
fun bar(): Unit {
foo(1, 2)(((if (true) {
({x, y -> x + y})
} else {
({x, y -> x + y})
}))!!)
foo(1L, 2L)({x, y -> x + y})
foo(1f, 2f)({x, y -> x + y})
foo(1.toDouble(), 2.toDouble())({x, y -> x + y})
foo(1.toByte(), 2.toByte())({x, y -> x + y})
foo(1.toShort(), 2.toShort())({x, y -> x + y})
foo('a', 'b')({x, y -> x == y})
foo(true, false)({x, y -> x || y})
}