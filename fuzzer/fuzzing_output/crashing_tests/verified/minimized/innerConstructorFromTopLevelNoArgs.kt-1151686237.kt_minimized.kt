class A {
inner class Inner {
val o = 111
val k = 222
}
}
fun box(): String {
val result = ((when {
(A::Inner) in null -> (A::Inner)
else -> (A::Inner)
}))((::A)()).o + (A::Inner)(A()).k
return "OK"
}