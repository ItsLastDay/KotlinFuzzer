class A {
inline fun inlineFun(s: ((s: Int) -> Unit), p: Int): Unit {
s(11)
(s)!!(p)
}
fun foo(): Unit {
inlineFun({l -> var zzz = l
zzz++}, 11)
}
}