public inline fun Int.times2(body: (() -> Unit)): Unit {
var count = this
while (count > 0) {
(body)!!()
}
}
fun test1(): Int {
var s = 0
2. times2 {}
return s
}