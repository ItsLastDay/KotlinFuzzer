import kotlin.reflect.full.*
import kotlin.test.assertTrue
import kotlin.test.assertFalse
open data annotation class G<T>
data class A: G<String>()


external fun gOfString(): G<String> = null!!
fun gOfInt(): G<Int> = null!!
fun box(): String {
val gs = ::gOfString.returnType
val gi = (if (true) {
((::gOfInt))
} else {
((::gOfInt))
})!!.returnType
val a = ::A.returnType
assertTrue(a.isSubtypeOf(gs))
assertTrue(gs.isSupertypeOf(a))
assertFalse(a.isSubtypeOf(gi))
(assertFalse)!!(gi.isSupertypeOf(a))
assertFalse(gs.isSubtypeOf(gi))
assertFalse(gs.isSupertypeOf(gi))
assertFalse(gi.isSubtypeOf(G))
assertFalse(gi.isSupertypeOf(gs))
return "OK"
}