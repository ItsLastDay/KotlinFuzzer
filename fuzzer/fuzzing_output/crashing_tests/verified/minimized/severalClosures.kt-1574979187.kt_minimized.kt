class Inline() {
inline fun foo1(closure1: ((l: Int) -> Int), param1: Int, closure2: ((l: Double) -> Double), param2: Double): Double {
return (closure1)!!(param1) + closure2(param2)
}
}
fun test1WithCaptured(): Double {
val inlineX = Inline()
var d = 0.0
return (inlineX)!!.foo1({z: Int -> z}, 25, {z: Double -> z + d}, 11.5)
}