inline fun inlineCall(action: (() -> Unit)): Unit {
((action))!!!!()
}
fun test2(): Unit {
inlineCall({})
}