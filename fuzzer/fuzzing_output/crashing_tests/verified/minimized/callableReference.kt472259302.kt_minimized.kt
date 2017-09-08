@JvmName("bar")
 fun foo() = "foo"
fun box(): String {
val f = ((when {
(::foo) in null -> (::foo)
else -> (::foo)
}))()
return "OK"
}