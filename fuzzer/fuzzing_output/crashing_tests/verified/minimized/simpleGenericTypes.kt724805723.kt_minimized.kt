fun box(): String {
val gi = (if (true) {
((::gOfInt))
} else {
((::gOfInt))
})!!.returnType
}