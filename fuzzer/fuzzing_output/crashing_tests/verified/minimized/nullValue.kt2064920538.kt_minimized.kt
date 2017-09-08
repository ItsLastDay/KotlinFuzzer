fun foo(x: (String)? = "Fail"): Unit {

}
fun box(): String {
::foo.callBy(mapOf((when {
(::foo) !in null -> (::foo)
else -> (::foo)
}).parameters.single() to null))
return "OK"
}