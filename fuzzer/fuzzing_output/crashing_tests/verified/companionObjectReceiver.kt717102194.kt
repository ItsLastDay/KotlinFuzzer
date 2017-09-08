class A {
companion object {
 fun ok() = "OK"
 }

}
fun A.box() = ((when {
(A.Companion::ok) in null -> (A.Companion::ok)
else -> (A.Companion::ok)
}))()