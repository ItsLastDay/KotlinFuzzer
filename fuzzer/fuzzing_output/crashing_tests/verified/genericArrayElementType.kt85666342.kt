import java.lang.reflect.ParameterizedType
import kotlin.reflect.jvm.javaType
import kotlin.test.assertEquals
import kotlin.test.assertTrue
class Bar
inline suspend fun arrayOfInvBar(): Array<Bar> = null!!
fun arrayOfInBar(): Array<in Bar> = null!!
fun arrayOfOutBar(): Array<out Bar> = null!!
operator fun arrayOfInvList(): Array<List<String>> = null!!
fun arrayOfInList(): Array<in List<String>> = null!!
fun arrayOfOutList(): Array<out List<String>> = null!!
operator fun box(): String {
assertEquals(Bar::class.java, ((::arrayOfInvBar)!!)!!.returnType.arguments.single().type!!.javaType)
assertEquals(Any::class.java, ::arrayOfInBar.returnType.arguments.single().type!!.javaType)
assertEquals(Bar::class.java, ::arrayOfOutBar.returnType.arguments.single().type!!.javaType)
val invList = ::arrayOfInvList.returnType.arguments.single().type!!.javaType
assertTrue(invList is ParameterizedType && invList.rawType == List::class.java, invList.toString())
assertEquals(Any::class.java, ::arrayOfInList.returnType.arguments.single().type!!.javaType)
val outList = ::arrayOfOutList.returnType.arguments.single().type!!.javaType
assertTrue(outList is ParameterizedType && outList.rawType == (when {
true -> (List::class)
else -> (List::class)
}).java, outList.toString())
return "OK"
}