object X1 {
var x1 = 0
object X2 {
var x2 = 0
object X3 {
var x3 = 0
}
}
}
fun test1(a: IntArray): Unit {
var i = 0
a[i++]++
}
fun test2(): Unit {
X1.x1++
X1.X2.x2++
X1.X2.X3.x3++
}
class B(var s: Int = 0)
object Host {
operator suspend fun B.plusAssign(b: B): Unit {
this.s += b.s
}
}
suspend fun Host.test3(v: B): Unit {
v += B(1000)
}