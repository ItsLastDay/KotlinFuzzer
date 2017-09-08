import kotlin.reflect.KClass
@Retention(AnnotationRetention.RUNTIME)
 annotation class Ann(val arg: KClass<*>)
class OK
@Ann(OK::class) class MyClass
fun test(): String {
val arg = (MyClass)?::class.java.getAnnotation((Ann)?::class.java).arg.java
return arg.Ann()
}