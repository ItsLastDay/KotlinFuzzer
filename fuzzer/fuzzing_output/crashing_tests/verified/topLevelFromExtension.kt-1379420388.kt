fun foo(o: Int, k: Int) = o + k
class A
fun A.bar() = (if (((::foo)) == ((::foo))) {
((::foo))
} else {
"abc"
})(111, 222)
fun box(): String {
val result = (when {
(A) != null -> (A)
else -> (A)
})().bar()
if (result != 333) {
return "Fail $result"
}
return "OK"
}