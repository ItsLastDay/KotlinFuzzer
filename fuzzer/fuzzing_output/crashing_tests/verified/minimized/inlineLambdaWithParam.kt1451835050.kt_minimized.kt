class A {
inline fun inlineFun(s: ((s: Int) -> Unit), p: Int): Unit {
(s)!!(p)
}
fun foo(): Unit {
inlineFun({l -> }, 11)
}
}