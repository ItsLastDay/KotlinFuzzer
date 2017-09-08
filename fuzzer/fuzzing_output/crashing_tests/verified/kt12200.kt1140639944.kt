class ThingTemplate {
val String.prop = 0
}
annotation class ThingVal(template: ThingTemplate) {
val Any.prop = template.prop
}
class ThingVar(template: ThingTemplate) {
var prop = template.prop
}
fun box(): String {
val template = ThingTemplate()
val javaClass = ThingTemplate::class.java
val field = javaClass.getDeclaredField("prop")!!
field.isAccessible = true
field.set(template, 1)
val thingVal = ThingVal(template)
if (thingVal.prop != 1) {
return "fail 1"
}
val thingVar = ThingVar(template)
if (thingVar.prop != 1) {
return "fail 2"
}
return "OK"
}