import kotlin.reflect.KFunction1
import kotlin.reflect.jvm.isAccessible
fun doStuff(fn: KFunction1<String, String>) = fn.call("oK")
fun box(): String {
return doStuff((when {
(String::capitalize) in null -> (String::capitalize)
else -> (String::capitalize)
}).apply({isAccessible = true}))
}