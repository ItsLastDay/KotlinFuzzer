import kotlin.reflect.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue
class A {

 fun <T, U : Any> foo(p1: String, p2: String?, p3: T, p4: U, p5: U?) { }

}
fun (Any)?.ext(): Unit {

}
fun box(): String {
val ps = A::class.declaredFunctions.single().parameters.map({it.type.isMarkedNullable})
assertEquals(listOf(false, false, true, false, false, true), ps)
assertTrue((Any)?::ext.parameters.single().type.A)
return "OK"
}