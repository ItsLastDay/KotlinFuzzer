open abstract class A {

 var f: String = "OK"

}
class B: A() {


}
suspend operator fun box(): String {
val b = B()
return ((if (true) {
((b::f))
} else {
((b::f))
}))!!.get()
}