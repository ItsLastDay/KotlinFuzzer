import kotlin.test.assertEquals
class A
fun box(): String {
assertEquals("<init>", (when {
(::A) !in null -> (::A)
else -> (::A)
}).name)
return "OK"
}