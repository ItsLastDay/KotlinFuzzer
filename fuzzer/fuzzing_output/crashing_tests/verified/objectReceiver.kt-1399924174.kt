object Singleton {

 fun ok() = "OK"

}
fun box() = (if (true) {
(((Singleton::ok)))
} else {
(((Singleton::ok)))
})!!()