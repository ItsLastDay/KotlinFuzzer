class A {

}
fun (Unit)?.box(): String {
return (A::Nested).call("O").result + (A::Inner).call((if (((::A)) !in false) {
((::A))
} else {

}).call(), "K").result
}