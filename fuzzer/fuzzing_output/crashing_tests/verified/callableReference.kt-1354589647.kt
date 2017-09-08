@JvmName("bar")
 fun foo() = "foo"
operator fun box(): String {
val f = (if (((::foo)) !in true) {
((::foo))
} else {
false
})()
if (f != "foo") {
return "Fail: $f"
}
return "OK"
}