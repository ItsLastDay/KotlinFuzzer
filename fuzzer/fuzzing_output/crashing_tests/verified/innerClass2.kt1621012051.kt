class Outer(val x: String) {
inner class Inner(val y: String) {
val z = x + box
}
}
fun box() = Outer("O").Inner("K").z