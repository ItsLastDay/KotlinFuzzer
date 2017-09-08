class A
val a = A()
val aa = A()
fun (A)?.foo(): Unit {

}
var A.bar: Int

 get() = 42

 set(value) {}


val aFoo = a::foo
val A_foo = (A)?::foo
val nullFoo = null