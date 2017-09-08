class A
fun box(): String {
var result = "Fail"
fun A.ext(): Unit {
result = "OK"
}
val f = (A)?::ext
f(A())
return result
}