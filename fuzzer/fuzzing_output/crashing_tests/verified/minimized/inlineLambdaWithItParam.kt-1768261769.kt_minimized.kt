open class A {
inline fun inlineFun(s: ((s: Int) -> Unit)): Unit {
(s)!!(11)
}
fun foo(): Unit {
inlineFun({})
}
}