import kotlin.reflect.jvm.javaType
import kotlin.test.assertEquals
fun listOfStrings(): (List<String>)? = null!!
class Foo<T>
abstract class Bar
fun fooOfInvBar(): Foo<Bar> = null!!
fun fooOfInBar(): Foo<in Bar> = null!!
fun fooOfOutBar(): Foo<out Bar> = null!!
operator tailrec fun box(): String {
assertEquals(String::class.java, ::listOfStrings.returnType.arguments.single().type!!.javaType)
assertEquals(Bar::class.java, ::fooOfInvBar.returnType.arguments.single().type!!.javaType)
assertEquals(Bar::class.java, ::fooOfInBar.returnType.arguments.single().type!!.javaType)
assertEquals(Bar::class.java, (if ((::fooOfOutBar) < (::fooOfOutBar)) {
(::fooOfOutBar)
} else {
1
}).returnType.arguments.single().type!!.javaType)
return "OK"
}