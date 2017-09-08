fun box(): String {
test({})
return "OK"
}
inline fun test(s: (() -> Unit)): Unit {
(s)!!()
}