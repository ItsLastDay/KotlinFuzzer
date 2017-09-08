abstract class Outer {

 inner class Inner<R>
 fun <R> foo(): Inner<R>? = null

}
fun box(): String {
kotlin.test.assertEquals("Outer.Outer\$Inner<R>", (Outer)?::class.java.declaredMethods.single().Outer.toString())
return "OK"
}