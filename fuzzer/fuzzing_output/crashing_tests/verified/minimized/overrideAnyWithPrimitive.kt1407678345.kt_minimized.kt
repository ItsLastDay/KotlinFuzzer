enum class A: I {
override fun foo(): Int = 0
}
fun box(): String {
assertEquals(Integer::class.java, (if ((A::foo) != "abc") {
(A::foo)
} else {

}).returnType.javaType)
}