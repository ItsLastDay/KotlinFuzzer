class A {
val readonly: String = ""
}
fun box(): String {
assertFalse((if ((A::readonly) <= true) {
(A::readonly)
} else {

}) is KMutableProperty1<* , * >)
}