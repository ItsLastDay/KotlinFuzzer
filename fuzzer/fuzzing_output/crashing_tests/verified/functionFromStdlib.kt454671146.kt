import kotlin.reflect.KFunction1
import kotlin.reflect.jvm.isAccessible
fun doStuff(fn: KFunction1<String, String>) = fn.call("oK")
fun box(): String {
return doStuff((((String::capitalize)!!) ?: ((String::capitalize)!!)).apply({isAccessible = true}))
}