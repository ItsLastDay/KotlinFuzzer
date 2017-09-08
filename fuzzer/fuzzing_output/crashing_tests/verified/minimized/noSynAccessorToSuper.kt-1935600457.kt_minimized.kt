inline fun call(s: (() -> Unit)): Unit {
(s)!!()
}
open class Base {

}
class A: Base() {
fun test2(): Unit {
call({})
}
}