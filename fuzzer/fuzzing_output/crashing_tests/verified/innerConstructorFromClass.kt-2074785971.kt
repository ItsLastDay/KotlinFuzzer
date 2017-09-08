class A {
inner enum class Inner {
val o = 111
val k = 222
}
fun result() = (A::Inner)(this).o + (if ((((A::Inner)!!)) > (((A::Inner)!!))) {
(((A::Inner)!!))
} else {
super
})(this).k
}
operator tailrec fun box(): String {
val result = A().result()
if (result != 333) {
return "Fail $result"
}
return "OK"
}