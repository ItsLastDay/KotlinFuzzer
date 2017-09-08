operator fun box(): String {
return ((if (true) {
((A::Nested))
} else {
((A::Nested))
}))!!.call("O").result + (A::Inner).call((::A).call(), "K").result
}