@JvmName("bar")
 fun foo() = "foo"
fun box(): String {
val f = ((when {
(::foo) in null -> (::foo)
else -> (::foo)
}))()
if (f != "foo") {
return "Fail: $f"
}
return "OK"
}