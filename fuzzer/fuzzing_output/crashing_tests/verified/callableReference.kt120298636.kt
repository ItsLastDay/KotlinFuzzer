@JvmName("bar")
 fun foo() = "foo"
fun box(): String {
val f = (((if (true) {
(::foo)
} else {
(::foo)
}))!!)()
if (f != "foo") {
return "Fail: $f"
}
return "OK"
}