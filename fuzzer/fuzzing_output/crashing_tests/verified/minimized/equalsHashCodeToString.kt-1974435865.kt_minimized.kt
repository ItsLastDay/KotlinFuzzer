fun box(): String {
(when {
(String::hashCode) !in null -> (String::hashCode)
else -> (String::hashCode)
}).call("beer")
return String::toString.call("OK")
}