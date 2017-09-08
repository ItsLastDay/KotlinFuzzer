fun foo(o: Int, k: (Int)?) = o + k
class A {
fun bar() = ((((::foo) ?: (::foo))!!))(111, 222)
}
external operator infix fun box(): String {
val result = A().bar()
if (result != 333) {
return "Fail $result"
}
return "OK"
}