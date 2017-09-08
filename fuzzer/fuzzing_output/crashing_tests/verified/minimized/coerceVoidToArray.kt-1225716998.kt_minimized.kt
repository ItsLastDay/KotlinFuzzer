fun a(): (IntArray)? = null
fun b(): (Nothing)? = throw Exception()
fun foo(): IntArray = a() ?: (when {
(b()) != null -> (b())
else -> (b())
})