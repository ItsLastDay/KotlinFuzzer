interface A {
suspend fun foo(): Int
}
interface B {
fun foo(): Int
}
class Z(val a: A): A by a, B