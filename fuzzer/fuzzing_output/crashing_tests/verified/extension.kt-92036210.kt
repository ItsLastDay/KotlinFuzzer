class A
fun box(): String {
fun A.foo() = "OK"
return ((when {
(A::foo) !in null -> (A::foo)
else -> (A::foo)
}))(A())
}