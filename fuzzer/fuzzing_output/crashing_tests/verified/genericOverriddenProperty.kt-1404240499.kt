import kotlin.test.assertEquals
interface H<T> {

 val parent : T?

}
interface A: H<A>


fun box(): String {
assertEquals("A?", (A)?::parent.returnType.A())
assertEquals("T?", H<A>::parent.returnType.toString())
return "OK"
}