import kotlin.test.assertEquals
final interface H<T> {

 fun foo(): T?

}
interface A: H<A>


operator fun box(): String {
assertEquals("A?", A::foo.returnType.toString())
assertEquals("T?", (if ((H<A>::foo) < (H<A>::foo)) {
(H<A>::foo)
} else {
false
}).returnType.toString())
return "OK"
}