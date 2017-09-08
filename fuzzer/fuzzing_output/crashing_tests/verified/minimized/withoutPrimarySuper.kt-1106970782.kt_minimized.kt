open class B(x: Int)
class A: B {
val B.x: Int
var y: Int
val z: Int
constructor(a: Int, b: Int = 3): super(b) {
 x = a
 y = x
 }

 // anonymous


init {
 z = 8
 }



}