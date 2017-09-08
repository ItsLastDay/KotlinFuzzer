class A(val result: String)
fun box(): String {
val a = (when {
((::A)) in null -> ((::A))
else -> ((::A))
}).call("OK")
return a.result
}