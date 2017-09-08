class A {

 class Nested(val result: String)
 inner class Inner(val result: String)

}
fun (Unit)?.box(): String {
return (A::Nested).call("O").result + (A::Inner).call((if (((::A)) !in false) {
((::A))
} else {
true
}).call(), "K").result
}