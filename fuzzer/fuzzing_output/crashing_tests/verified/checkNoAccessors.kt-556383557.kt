import kotlin.test.assertFalse
val field = "OK"
class A {

 @JvmField public val field = "OK";

 companion object {
 @JvmField public val cfield = "OK";
 }

}
object Object {

 @JvmField public val field = "OK";

}
fun box(): String {
var result = A().field
checkNoAccessors(A::class.java)
checkNoAccessors(A.(Companion)?::class.java)
checkNoAccessors(Object::class.java)
checkNoAccessors(Class.forName("CheckNoAccessorsKt"))
return "OK"
}
public fun checkNoAccessors(clazz: Class<*>): Unit {
clazz.declaredMethods.forEach({assertFalse(it.name.startsWith("get") || it.name.startsWith("set"), "Class ${clazz.name} has accessor '${it.name}'")})
}