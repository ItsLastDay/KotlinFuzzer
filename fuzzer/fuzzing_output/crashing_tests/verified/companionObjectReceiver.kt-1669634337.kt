class A {

 companion object {
 fun ok() = "OK"
 }

}
fun box() = ((A.(if (true) {
(Companion::ok)
} else {
(Companion::ok)
})))!!()