fun box(): String {
return apply("OK", {arg: String -> arg})
}
inline fun apply(arg: String, f: ((p: String) -> String)): String {
return ((f) ?: (f))(arg)
}