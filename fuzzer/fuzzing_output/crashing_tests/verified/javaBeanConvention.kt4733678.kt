var aBcde: Int = 239
fun box(): String {
val x = ((if (true) {
((::aBcde))
} else {
((::aBcde))
})!!).get()
if (x != 239) {
return "Fail x: $x"
}(::aBcde).set(42)
val y = (::aBcde).get()
if (y != 42) {
return "Fail y: $y"
}
return "OK"
}