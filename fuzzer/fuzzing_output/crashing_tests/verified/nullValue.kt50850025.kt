import kotlin.test.assertNull
fun foo(x: (String)? = "Fail"): Unit {
assertNull(x)
}
fun box(): (String)? {
::foo.(callBy(mapOf(((::foo))!!!!.parameters.single() to null)))!!
return "OK"
}