inline fun <R> test(s: (() -> R)): R {
var b = false
try {
return (s)!!()
}
finally {
(! b)
}
}
fun box(): String {
try {
test({return@box "OK"})
}
finally {

}
return "fail"
}