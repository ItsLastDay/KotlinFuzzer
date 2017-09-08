open class A {
var f: String = "OK"
}
class B: A() {

}
fun box(): String {
val b = B()
return ((when {
(b::f) !in null -> (b::f)
else -> (b::f)
})).get()
}