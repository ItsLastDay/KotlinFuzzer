fun foo(o: Int, k: Int) = o + k
class A
fun A.bar() = ((when {
(::foo) in null -> (::foo)
else -> (::foo)
}))(111, 222)