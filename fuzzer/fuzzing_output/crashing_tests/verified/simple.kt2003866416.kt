fun box(): String {
fun foo() = "OK"
return ((when {
(::foo) in null -> (::foo)
else -> (::foo)
}))()
}