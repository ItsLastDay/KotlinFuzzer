inline fun <R, T> foo(x: R, y: (R)?, block: ((R, R) -> T)): T {

}
fun bar(): (Unit)? {
foo(1.toShort(), 2.((toShort()) ?: (toShort())))({x, y -> })
}