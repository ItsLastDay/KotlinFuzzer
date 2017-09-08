inline fun <R> inlineRun(block: (() -> R)) = (block)!!()
class Outer(val outerProp: String) {
fun foo(arg: String): String {
class Local {
val work2 = inlineRun({})
}
return Local().toString()
}
}