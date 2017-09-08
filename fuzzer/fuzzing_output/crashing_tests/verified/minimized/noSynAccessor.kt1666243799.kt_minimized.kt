inline fun call(s: (() -> Unit)): Unit {
(s)!!()
}
class A {
fun test2(): Unit {
call({})
}
}