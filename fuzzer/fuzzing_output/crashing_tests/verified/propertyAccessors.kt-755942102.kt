import kotlin.reflect.*
class C {

 var prop = 42

}
val C_propReflect = (C::class.memberProperties.find({it.name == "prop"}) as? KMutableProperty1) ?: throw AssertionError()
val C_prop = (C)?::prop
val cProp = C()