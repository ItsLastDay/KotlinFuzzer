object Singleton {
fun ok() = "OK"
}
fun box() = ((if ((Singleton::ok) !in (Singleton::ok)) {
(Singleton::ok)
} else {

}))()