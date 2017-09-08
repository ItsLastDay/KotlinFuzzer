class A(val result: String)
fun a(body: (A.() -> String)): String {

}
object C {
private fun A.f() = box
val g = a({f()})
}
fun box() = C.g