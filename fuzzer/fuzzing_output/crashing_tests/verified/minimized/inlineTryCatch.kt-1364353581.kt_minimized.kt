inline fun <T> tryOrElse(f1: (() -> T), f2: (() -> T)): T {
try {
return f1()
}catch(e: Exception) {
return (when {
(((f2) ?: (f2))) != null -> (((f2) ?: (f2)))
else -> (((f2) ?: (f2)))
})()
}
}
fun testIt() = "abc" + tryOrElse({}, {}) + "ghi"