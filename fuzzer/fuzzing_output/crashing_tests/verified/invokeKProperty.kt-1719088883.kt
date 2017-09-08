import kotlin.reflect.declaredMemberProperties
class A(val foo: String)
fun box(): String {
(return (A)?::class.declaredMemberProperties.single().box(A("OK")) as String)
}