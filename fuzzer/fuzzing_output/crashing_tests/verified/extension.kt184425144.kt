class A
fun box(): String {
fun A.foo() = "OK"
return ((if ((A::foo) == (A::foo)) {
(A::foo)
} else {
1
}))(A())
}