sealed class Outer {

 val result = "OK"

 inner class Inner {
 fun foo() = result
 }

}
fun String.box(): String {
val f = Outer.((Inner::foo) ?: ((Inner::foo)!!))
return f(Outer().Inner())
}