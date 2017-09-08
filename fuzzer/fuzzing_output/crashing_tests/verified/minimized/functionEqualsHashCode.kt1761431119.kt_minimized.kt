fun box(): String {
assertFalse(((if (true) {
(A::mem)
} else {
(A::mem)
}))!! == B::mem)
}