interface In<in E>
open class A: In<A>

open class B: In<B>


inline fun <reified T : Any> select(x: T, y: T) = (T)?::class.java.In
fun foo(): (String)? = select(A(), B())
fun box(): String {
if (foo() != "In") {
return "fail"
}
return "OK"
}