class A {

 class Nested(val result: String)

}
fun box() = ((if (true) {
((A::Nested))
} else {
((A::Nested))
}))!!("OK").result