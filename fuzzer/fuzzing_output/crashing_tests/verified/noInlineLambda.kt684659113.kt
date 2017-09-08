package test
interface A {

 fun run()

}
inline infix fun testNested(f: ((String) -> Unit)): Unit {
object: A{

 override fun run() {
 f("OK")
 }

}.run()
}
fun test(f: ((String) -> Unit)): Unit {
testNested((if (true) {
({it -> {f(it)}()})
} else {
({it -> {f(it)}()})
}))
}