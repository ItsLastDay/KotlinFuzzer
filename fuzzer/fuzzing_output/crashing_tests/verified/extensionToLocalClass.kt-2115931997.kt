fun box(): String {
class A
fun A.foo() = "OK"
return (A::foo)((((if (true) {
(::A)
} else {
(::A)
}))!!)())
}