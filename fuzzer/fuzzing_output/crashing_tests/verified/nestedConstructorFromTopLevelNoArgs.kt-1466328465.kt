class A {

 class Nested {
 val result = "OK"
 }

}
fun box() = (((if (true) {
(A::Nested)
} else {
(A::Nested)
}))!!)().result