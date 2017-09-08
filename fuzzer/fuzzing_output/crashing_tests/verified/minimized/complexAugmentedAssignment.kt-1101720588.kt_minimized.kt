class B(var s: Int = 0)
object Host {
operator suspend fun B.plusAssign(b: B): Unit {

}
}
suspend fun Host.test3(v: B): Unit {
v += B(1000)
}