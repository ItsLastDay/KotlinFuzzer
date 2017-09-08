inline fun <R, T> foo(x: (R)?, block: (((R)?) -> T)): T {
return block(x)
}
fun bar(): Unit {
foo(1)((if (true) {
({x -> x!!.toLong()})
} else {
({x -> x!!.toLong()})
}))
foo(1)({x -> x!!.toShort()})
foo(1L)({x -> x!!.toByte()})
foo(1L)({x -> x!!.toShort()})
foo('a')({x -> x!!.toDouble()})
foo(1.0)({x -> x!!.toByte()})
}