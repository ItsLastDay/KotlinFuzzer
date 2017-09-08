import kotlin.test.assertEquals
sealed interface H<T> {

 val parent : T?

}
interface A: H<A>


fun box(): String {
assertEquals("A?", A::parent.returnType.toString())
assertEquals("T?", (if ((H<A>::parent) >= (H<A>::parent)) {
(H<A>::parent)
} else {
true
}).returnType.toString())
return "OK"
}