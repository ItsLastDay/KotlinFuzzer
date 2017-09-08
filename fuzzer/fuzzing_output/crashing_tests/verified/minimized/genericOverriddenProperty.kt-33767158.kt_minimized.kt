import kotlin.test.assertEquals
interface H<T> {
val parent: (T)?
}
interface A: H<A>



fun box(): String {
assertEquals("A?", (when {
(A::parent) in null -> (A::parent)
else -> (A::parent)
}).returnType.toString())
return "OK"
}