class A {
class Nested {
val o = 111
val k = 222
}
fun result() = (::Nested)().o + (if (((A::Nested)) < 1) {
((A::Nested))
} else {
1
})().k
}
fun box(): String {
val result = A().result()
if (result != 333) {
return "Fail $result"
}
return "OK"
}