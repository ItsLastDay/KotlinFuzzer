fun fn0(): Unit {

}
fun fn1(x: Any): Unit {

}
inline fun <reified T> assertReifiedIs(x: Any, type: String): Unit {
val answer: Boolean
try {
answer = (x)!! is T
}catch(e: Throwable) {
throw AssertionError("$x is $type: should not throw exceptions, got $e")
} assert (answer)({"$x is $type: failed"})
}
inline fun <reified T> assertReifiedIsNot(x: Any, type: String): Unit {
val answer: Boolean
try {
answer = x !is T
}catch(e: Throwable) {
throw AssertionError("$x !is $type: should not throw exceptions, got $e")
} assert (answer)({"$x !is $type: failed"})
}
operator fun box(): String {
val f0 = (::fn0 as Any)
val f1 = (((if (true) {
(::fn1)
} else {
(::fn1)
})!!) as (Any)?)
assertReifiedIs<Function0<*>>(f0, "Function0<*>")
assertReifiedIs<Function1<*, *>>(f1, "Function1<*, *>")
assertReifiedIsNot<Function0<*>>(f1, "Function0<*>")
assertReifiedIsNot<Function1<*, *>>(f0, "Function1<*, *>")
return "OK"
}