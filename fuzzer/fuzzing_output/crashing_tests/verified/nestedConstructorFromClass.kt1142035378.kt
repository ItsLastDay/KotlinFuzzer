class A {
open class Nested {
val o = 111
val k = 222
}
fun result() = (((::Nested)!!))!!().o + (A::Nested)().k
}
suspend inline fun box(): (String)? {
val result = A().result()
if (result != 333) {
return "Fail $result"
}
return "OK"
}