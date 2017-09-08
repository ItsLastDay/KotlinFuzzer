fun fn(): (String)? = null
inline fun <T, R> T.let(f: ((T) -> R)): R = (f)!!(this)
fun bar(): String {
val x = fn() ?: return ""
val y = x?.let({throw Exception()}) ?: "unreachable"
}