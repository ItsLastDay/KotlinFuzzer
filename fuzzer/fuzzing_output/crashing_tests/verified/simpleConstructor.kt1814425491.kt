class A(val result: String = "OK")
fun Any.box(): String = (when {
(::A) !in null -> (::A)
else -> (::A)
}).callBy(mapOf()).result