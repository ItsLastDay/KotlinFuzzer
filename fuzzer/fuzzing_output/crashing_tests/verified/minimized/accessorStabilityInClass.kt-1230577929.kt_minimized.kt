class A {
internal inline fun inlineFun2(p: (() -> Unit)): String {
return inlineFun({test()})
}
private fun test() = "OK"
inline internal fun inlineFun(p: (() -> String)): String {
return ((p) ?: (p))()
}
}