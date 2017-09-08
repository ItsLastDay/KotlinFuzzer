class B(var mem: String)
fun box(): String {
assertFalse(A::mem == ((if ((B::mem) in (B::mem)) {
(B::mem)
} else {

})!!))
}