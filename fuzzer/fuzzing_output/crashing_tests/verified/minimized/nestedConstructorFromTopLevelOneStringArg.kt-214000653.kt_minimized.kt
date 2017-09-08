abstract class A {
class Nested(val result: String)
}
fun box() = ((when {
((if ((A::Nested) == 1) {

} else {

})) != null -> ((if ((A::Nested) == 1) {
(A::Nested)
} else {
false
}))
else -> ((if ((A::Nested) == 1) {
(A::Nested)
} else {
false
}))
}))("OK").result