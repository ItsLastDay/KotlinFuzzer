import kotlin.test.assertTrue
interface Interface
object Obj
class C {

 companion object

}
fun box(): String {
assertTrue((Interface)?::class.constructors.isEmpty())
assertTrue(Obj::class.constructors.isEmpty())
assertTrue(C.Companion::class.constructors.isEmpty())
return "OK"
}