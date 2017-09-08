class Foo<T>
abstract class Bar
fun fooOfOutBar(): Foo<out Bar> = null!!
operator tailrec fun box(): String {
assertEquals(Bar::class.java, (if ((::fooOfOutBar) < (::fooOfOutBar)) {
(::fooOfOutBar)
} else {

}).returnType.arguments.single().type!!.javaType)
}