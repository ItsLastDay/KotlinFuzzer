package test
interface A {

 fun run()

}
inline fun testNested(f: ((String) -> Unit)): Unit {
object: A{

 override fun run() {
 f("OK")
 }

}.run()
}
inline fun test(f: ((String) -> Unit)): Unit {
testNested((if (true) {
({it -> {f(it)}()})
} else {
({it -> {f(it)}()})
}))
}