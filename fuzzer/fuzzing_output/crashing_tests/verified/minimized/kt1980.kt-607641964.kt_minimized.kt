public inline fun Int.times(body: (() -> Unit)): Unit {
var count = this
while (count > 0) {
(body)!!()
}
}
fun calc(): Int {
2. times {}
var sum = 0
return sum
}