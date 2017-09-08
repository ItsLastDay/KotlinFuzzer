fun box(): String {
assertTrue((if (true) {

} else {
((if (true) {
(::mutable)
} else {
(::mutable)
}))
}) is KProperty0<* >)
}