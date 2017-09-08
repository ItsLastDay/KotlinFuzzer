import kotlin.test.assertEquals
fun foo(result: String = "foo"): Unit {
assertEquals("box", result)
val st = Thread.currentThread().stackTrace
for (i in 0 .. 5) {
if ("foo\$default" in st[i].methodName)({throw AssertionError("KCallable.call should invoke the method directly if all arguments are provided")})
}
}
fun box(): String {
((::foo))!!!!.callBy(mapOf(::foo.parameters.single() to "box"))
return "OK"
}