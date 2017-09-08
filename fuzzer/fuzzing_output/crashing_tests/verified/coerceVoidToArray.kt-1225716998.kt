fun a(): (IntArray)? = null
fun b(): (Nothing)? = throw Exception()
fun foo(): IntArray = a() ?: (when {
(b()) != null -> (b())
else -> (b())
})
tailrec fun box(): String {
try {
foo()
}catch(e: Exception) {
return "OK"
}
return "Fail"
}