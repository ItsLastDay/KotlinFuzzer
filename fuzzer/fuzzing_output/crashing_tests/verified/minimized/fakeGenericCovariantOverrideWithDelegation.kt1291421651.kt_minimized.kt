interface A<T> {
fun foo(t: T): String
}
interface B {
suspend fun foo(t: Int) = "B"
}
class Z2: B by Z(), A<Int>