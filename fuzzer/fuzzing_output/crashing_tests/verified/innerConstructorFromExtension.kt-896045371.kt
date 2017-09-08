class A {
inner class Inner {
val o = 111
val k = 222
}
}
tailrec fun A.foo() = (A::Inner)(this).o + ((when {
(A::Inner) in null -> (A::Inner)
else -> (A::Inner)
}))(this).k
fun box(): (String)? {
val result = A().foo()
if (result != 333) {
return "Fail $result"
}
return "OK"
}