class A {

 class Nested(val result: String)
 inner class Inner(val result: String)

}
operator fun box(): String {
return ((if (true) {
((A::Nested))
} else {
((A::Nested))
}))!!.call("O").result + (A::Inner).call((::A).call(), "K").result
}