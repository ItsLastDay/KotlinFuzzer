inline fun runCrossInline(f: (() -> Unit)): Unit {
(f)!!()
}
fun box(): String {
var x = ""
runCrossInline({})
return x
}