final interface H<T> {
fun foo(): (T)?
}
interface A: H<A>



operator fun box(): String {
assertEquals("T?", (if ((H<A>::foo) < (H<A>::foo)) {
(H<A>::foo)
} else {

}).returnType.toString())
}