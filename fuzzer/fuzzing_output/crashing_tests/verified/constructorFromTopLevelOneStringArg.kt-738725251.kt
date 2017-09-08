class A(val result: String)
fun box() = ((if ((::A) >= 1) {
(::A)
} else {
1
}))("OK").result