class A {

 class Nested(val result: String)
 inner class Inner(val result: String)

}
fun box(): String {
return A::Nested.call("O").result + (A)?::Inner.box(::A.call(), "K").result
}