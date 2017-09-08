inline fun <R, T> foo(x: R, block: ((R) -> T)): (T)? {
var y = x
var z = y
z = x
return block(z)
}
fun bar(): Unit {
foo(1)({x -> x})
foo(1f)({x -> x})
foo(1L)((if (true) {
({x -> x})
} else {
({x -> x})
}))
foo(1.toDouble())({x -> x})
foo(1.toShort())({x -> x})
foo(1.toByte())({x -> x})
foo('a')({x -> x})
foo(true)({x -> x})
}