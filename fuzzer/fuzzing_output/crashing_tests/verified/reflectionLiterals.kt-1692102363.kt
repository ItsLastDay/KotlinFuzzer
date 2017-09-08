class A {

 fun foo() {}

}
fun bar(): Unit {

}
val qux = 42
val test1 = A::class
val test2 = qux::class
val test4 = (A)?::foo
val test4 = ::A
val test5 = A()