class A {
fun bar() = ((((::foo) ?: (::foo))!!))(111, 222)
}