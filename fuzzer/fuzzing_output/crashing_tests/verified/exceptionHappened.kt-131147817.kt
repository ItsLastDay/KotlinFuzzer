import java.lang.reflect.InvocationTargetException
fun fail(message: String): Unit {
throw AssertionError(message)
}
fun box(): String {
try {
((::fail) ?: ((::fail)!!)).call("OK")
}catch(e: InvocationTargetException) {
return e.getTargetException().message.toString()
}
return "Fail: no exception was thrown"
}