class A {
class Nested {
val o = 111
val k = 222
}
fun result() = (::Nested)().o + ((when {
(A::Nested) in null -> (A::Nested)
else -> (A::Nested)
}))().k
}