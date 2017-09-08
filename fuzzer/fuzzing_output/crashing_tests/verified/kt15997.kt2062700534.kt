package test
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
var result = "fail"
inline fun <reified T : Any> crashMe(): ReadWriteProperty<Any?, Unit> {
return Delegates.observable(Unit, {a, b, c -> result = (T)?::class.java.simpleName})
}