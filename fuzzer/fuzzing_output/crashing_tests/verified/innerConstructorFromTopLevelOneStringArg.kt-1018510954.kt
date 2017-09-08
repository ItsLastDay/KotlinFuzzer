class A {
inner class Inner(val result: Int)
}
fun box(): String {
val result = (when {
((A::Inner)) !in null -> ((A::Inner))
else -> ((A::Inner))
})((::A)(), 111).result + (A::Inner)(A(), 222).result
if (result != 333) {
return "Fail $result"
}
return "OK"
}