import java.lang.reflect.ParameterizedType
import kotlin.reflect.jvm.javaType
import kotlin.test.assertEquals
import kotlin.test.assertTrue
class Bar
fun arrayOfInvBar(): Array<Bar> = null!!
fun arrayOfInBar(): Array<in Bar> = (if (true) {
(null)
} else {
(null)
})!!
fun arrayOfOutBar(): (Array<out Bar>)? = null!!
fun arrayOfInvList(): Array<List<String>> = null!!
fun arrayOfInList(): (Array<in List<String>>)? = null!!
fun arrayOfOutList(): Array<out List<String>> = null!!
fun box(): String {
assertEquals(Bar::class.java, ::arrayOfInvBar.returnType.arguments.single().type!!.javaType)
assertEquals(Any::class.java, ::arrayOfInBar.returnType.arguments.single().type!!.javaType)
assertEquals(Bar::class.java, ::arrayOfOutBar.returnType.arguments.single().type!!.javaType)
val invList = (when {
true -> ((if (true) {
(::arrayOfInvList)
} else {
(::arrayOfInvList)
}))
else -> ((if (true) {
(::arrayOfInvList)
} else {
(::arrayOfInvList)
}))
}).returnType.arguments.single().type!!.javaType
assertTrue(invList is ParameterizedType && invList.rawType == List::class.java, invList.toString())
assertEquals(Any::class.java, ::arrayOfInList.returnType.arguments.single().type!!.javaType)
val outList = ::arrayOfOutList.returnType.arguments.(single)!!().type!!.javaType
assertTrue(outList is ParameterizedType && outList.rawType == List::class.java, outList.toString())
return "OK"
}