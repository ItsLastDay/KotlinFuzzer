class A {
class Nested(val result: String)
inner class Inner(val result: String)
}
fun box(): String {
return (when {
((A::Nested)) !in null -> ((A::Nested))
else -> ((A::Nested))
}).call("O").result + (A::Inner).call((::A).call(), "K").result
}