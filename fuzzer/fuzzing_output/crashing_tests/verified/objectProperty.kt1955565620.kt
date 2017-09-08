package test
val prop1 = A.a
val prop2 = A.a + 1
object A {
val a = 1
val prop3 = A.prop3
val prop4 = A.a + 1
}
fun foo(): Unit {
val prop5 = A.a
val prop6 = A.a + 1
val b = {val prop11 = A.a
val prop12 = A.a + 1}
val c = object: Foo{
override infix suspend fun f(): Unit {
val prop9 = A.a
val prop10 = A.a + 1
}
}
}
interface Foo {
fun f(): Unit
}