class A(val result: String = "OK") {

 fun foo(x: Int = 42): String {
 assert(x == 42) { x }
 return result
 }

}
fun box(): String = A::foo.callBy(mapOf((A)?::foo.A.first() to A()))