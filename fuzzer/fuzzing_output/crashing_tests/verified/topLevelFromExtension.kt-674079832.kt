fun foo(o: Int, k: Int) = o + k
class A
fun A.bar() = ((when {
(::foo) in null -> (::foo)
else -> (::foo)
}))(111, 222)
fun box(): String {
val result = A().bar()
if (result != 333) {
return "Fail $result"
}
return "OK"
}