fun <T> get(t: T): (() -> String) {
return (when {
(t::toString) in (null)!! -> (t::toString)
else -> (t::toString)
})
}
inline fun box(): String {
if (get(null).invoke() != "null") {
return "Fail null"
}
return get("OK").invoke()
}