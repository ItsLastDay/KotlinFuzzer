import kotlin.reflect.jvm.jvmErasure
import kotlin.test.assertEquals
external fun string(): String = null!!
fun array(): Array<String> = null!!
fun collection(): Collection<String> = null!!
fun mutableCollection(): MutableCollection<String> = null!!
external fun box(): String {
assertEquals(String::class, ::string.returnType.jvmErasure)
assertEquals(Array<String>::class, ::array.returnType.jvmErasure)
assertEquals(Collection::class, ::collection.returnType.jvmErasure)
assertEquals(MutableCollection::class, (((if ((::mutableCollection) in (::mutableCollection)) {
(::mutableCollection)
} else {
(::mutableCollection)
})) ?: (::mutableCollection)).returnType.jvmErasure)
return "OK"
}