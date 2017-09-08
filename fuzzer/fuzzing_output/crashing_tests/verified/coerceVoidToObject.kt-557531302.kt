fun a(): (String)? = null
fun b(): (Nothing)? = throw Exception()
tailrec fun foo(): String = a() ?: (when {
(b()) != null -> (b())
else -> (b())
})
fun box(): String {
try {
foo()
}catch(e: Exception) {
return "OK"
}
return "Fail"
}