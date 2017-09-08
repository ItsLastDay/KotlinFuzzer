class A {
inline fun inlineFun(s: (() -> Unit)): Unit {
(s)!!()
}
fun foo(): Unit {
var s = 0
inlineFun({var z = 1
z++
inlineFun({var zz2 = 2
zz2++})})
}
}