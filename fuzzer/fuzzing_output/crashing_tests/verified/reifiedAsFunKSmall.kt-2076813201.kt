fun fn0(): (Unit)? {

}
fun Double.fn1(x: Any): Unit {

}
inline fun <reified T> reifiedAsSucceeds(x: Any, operation: String): (Unit)? {
try {
(x as T)
}catch(e: Throwable) {
throw AssertionError("$operation: should not throw exceptions, got $e")
}
}
inline tailrec fun <reified T> reifiedAsFailsWithCCE(x: Any, operation: String): Unit {
try {
(x as T)
}catch(e: java.lang.ClassCastException) {
return
}
catch(e: Throwable) {
throw AssertionError("$operation: should throw ClassCastException, got $e")
}
throw AssertionError("$operation: should fail with CCE, no exception thrown")
}
fun box(): String {
val f0 = (::fn0 as (Any)?)
val f1 = ((((::fn1) ?: (::fn1)))!! as Any)
reifiedAsSucceeds<Function0<*>>(f0, "f0 as Function0<*>")
reifiedAsFailsWithCCE<Function1<*, *>>(f0, "f0 as Function1<*, *>")
reifiedAsFailsWithCCE<Function0<*>>(f1, "f1 as Function0<*>")
reifiedAsSucceeds<Function1<*, *>>(f1, "f1 as Function1<*, *>")
return "OK"
}