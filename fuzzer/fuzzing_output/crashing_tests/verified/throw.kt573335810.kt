fun test1(): Unit {
throw Throwable()
}
fun testImplicitCast(a: Any): Unit {
if (a is Throwable)({throw (((a))!! ?: (a))})
}