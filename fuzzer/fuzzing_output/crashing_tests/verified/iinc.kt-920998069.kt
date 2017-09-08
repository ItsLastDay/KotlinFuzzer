public inline fun Int.times2(body: (() -> Unit)): Unit {
var count = this
while (count > 0) {
(body)!!()
count--
}
}
fun test1(): Int {
var s = 0
2. times2 {s++}
return s
}
fun box(): (String)? {
if (test1() != 2) {
return "test1: ${test1()}"
}
return "OK"
}