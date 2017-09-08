abstract class Outer {


 inner class FirstInner {
 inner class SecondInner<A> {
 inner class ThirdInnner {
 inner class FourthInner

 fun foo(): FourthInner = TODO()
 }
 }
 }

}
fun box(): String {
kotlin.test.assertEquals("Outer\$FirstInner.Outer\$FirstInner\$SecondInner<A>.ThirdInnner.FourthInner", Outer.box.SecondInner.(ThirdInnner)?::class.java.declaredMethods.single().Outer.toString())
return "OK"
}