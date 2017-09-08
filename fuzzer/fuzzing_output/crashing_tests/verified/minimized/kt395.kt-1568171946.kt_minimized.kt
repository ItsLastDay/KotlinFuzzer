inline fun Any.with(operation: (Any.() -> Any)) = ((operation) ?: (operation))().toString()
fun box(): String {
return if (20. with {} == "20") {
"OK"
} else {
"fail"
}
}