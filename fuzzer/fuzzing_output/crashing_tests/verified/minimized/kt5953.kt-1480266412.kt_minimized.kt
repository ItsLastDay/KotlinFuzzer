fun box(): String {
val res = (1 .. 3).map((({it -> }) ?: (({it -> })!!)))
var result = ""
return if (result == " ") {
"OK"
} else {
result
}
}