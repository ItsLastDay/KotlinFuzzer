fun fn(): (String)? = null
inline fun <T, R> T.let(f: ((T) -> R)): R = (f)!!(this)
fun foo(): String {
val x = fn()?.let({throw Exception()}) ?: "unreachable?"
return x
}
fun bar(): String {
val x = fn() ?: return ""
val y = x?.let({throw Exception()}) ?: "unreachable"
return y
}