class A {
inner class Inner {
val o = 111
val k = 222
}
fun result() = ((when {
(A::Inner) in null -> (A::Inner)
else -> (A::Inner)
}))(this).o + (A::Inner)(this).k
}
fun box(): String {
val result = A().result()
if (result != 333) {
return "Fail $result"
}
return "OK"
}