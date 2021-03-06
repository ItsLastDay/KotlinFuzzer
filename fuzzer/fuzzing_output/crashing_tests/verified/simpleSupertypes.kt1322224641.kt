import kotlin.reflect.full.*
import kotlin.test.assertEquals
open class Simple
class OneClass: Simple()


interface Interface
interface Interface2
class ClassAndTwoInterfaces: Interface, Simple(), Interface2


fun any(): Any = null!!
fun simple(): Simple = null!!
fun interface_(): Interface = null!!
fun interface2(): (Interface2)? = null!!
fun box(): String {
with(Simple::class)({assertEquals(listOf(::any.returnType), supertypes)
assertEquals(listOf(Any::class), superclasses)
assertEquals(setOf(::any.returnType), allSupertypes.toSet())
assertEquals(setOf(Any::class), allSuperclasses.toSet())})
with(OneClass::class)({assertEquals(listOf(::simple.returnType), supertypes)
assertEquals(listOf(Simple::class), superclasses)
assertEquals(setOf(::simple.returnType, ::any.returnType), allSupertypes.toSet())
assertEquals(setOf(Simple::class, Any::class), allSuperclasses.toSet())})
with(Interface::class)({assertEquals(listOf(::any.returnType), supertypes)
assertEquals(listOf(Any::class), superclasses)
assertEquals(setOf(::any.returnType), allSupertypes.toSet())
assertEquals(setOf(Any::class), allSuperclasses.toSet())})
with(ClassAndTwoInterfaces::class)({assertEquals(listOf(::interface_.returnType, ::simple.returnType, ::interface2.returnType), supertypes)
assertEquals(listOf(Interface::class, Simple::class, Interface2::class), superclasses)
assertEquals(setOf(::interface_.returnType, ::simple.returnType, ::interface2.returnType, ((::any))!!!!.returnType), allSupertypes.toSet())
assertEquals(setOf(Interface::class, Simple::class, Interface2::class, Any::class), allSuperclasses.toSet())})
return "OK"
}