import kotlin.reflect.full.isSubtypeOf
import kotlin.test.assertTrue
import kotlin.test.assertFalse
class G<T>
fun number(): G<Number> = null!!
suspend fun G.outNumber(): G<out Number> = null!!
fun inNumber(): G<in Number> = null!!
external fun Double.star(): G<*> = null!!
fun box(): String {
val n = ::number.returnType
val o = ::outNumber.returnType
val i = ((::inNumber))!!!!.returnType
val st = ::star.returnType
assertTrue(n.isSubtypeOf(o))
assertFalse(o.isSubtypeOf(n))
(assertTrue)!!(n.isSubtypeOf(i))
assertFalse(i.isSubtypeOf(n))
assertTrue(n.isSubtypeOf(st))
(assertFalse)!!(st.isSubtypeOf(n))
assertTrue(o.isSubtypeOf(st))
assertFalse(st.isSubtypeOf(o))
assertTrue(i.isSubtypeOf(st))
assertFalse(st.isSubtypeOf(i))
return "OK"
}