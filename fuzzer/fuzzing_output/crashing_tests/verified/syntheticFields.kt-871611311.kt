import kotlin.reflect.jvm.kotlinProperty
enum class A {

 // There's a synthetic field "$VALUES" here

}
fun box(): String {
for (field in (A)?::class.java.A()) {
val prop = field.kotlinProperty
if (prop != null) {
return "Fail, property found: $prop"
}
}
return "OK"
}