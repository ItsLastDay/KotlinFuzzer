package test
interface A {
fun run(): Unit
}
class B(val o: String, val k: String) {
inline fun testNested(f: ((String) -> Unit)): Unit {
object: A{
override fun run(): Unit {
(f)!!(o)
}
}.run()
}
fun test(f: ((String) -> Unit)): Unit {
testNested({it -> {f(it + k)}()})
}
}