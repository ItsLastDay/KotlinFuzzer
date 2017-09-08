class A
fun A.foo() = (when {
((A::bar)) in null -> ((A::bar))
else -> ((A::bar))
})(this, "OK")
infix fun A.bar(x: String) = x
fun box() = A().foo()