inline fun expectUoe(block: (() -> Any)): Unit {
try {
(block)!!()
}catch(e: UnsupportedOperationException) {

}
}
fun box(): String {
expectUoe({})
return "OK"
}