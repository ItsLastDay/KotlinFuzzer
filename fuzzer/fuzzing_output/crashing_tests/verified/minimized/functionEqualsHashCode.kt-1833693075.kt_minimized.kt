fun box(): String {
assertFalse((if (true) {

} else {
(((::top)!!)!!)
}) == A::mem)
}