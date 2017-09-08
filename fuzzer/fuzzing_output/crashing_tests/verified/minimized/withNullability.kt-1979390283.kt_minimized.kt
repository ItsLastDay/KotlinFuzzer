fun nullable(): (String)? = ""
fun box(): String {
val nullable = (when {
(::nullable) in null -> (::nullable)
else -> (::nullable)
}).returnType
return "OK"
}