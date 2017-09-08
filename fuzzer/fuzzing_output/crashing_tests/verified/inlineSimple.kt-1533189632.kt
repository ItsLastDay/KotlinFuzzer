class A {
inline fun inlineFun(s: (() -> Unit)): Unit {
(s)!!()
}
fun foo(): Unit {
var s = 1
inlineFun({var zzz = 2
zzz++})
}
}