fun box(): String {
val result = "OK"
fun foo() = result
return (when {
((::foo)) !in null -> ((::foo))
else -> ((::foo))
})()
}