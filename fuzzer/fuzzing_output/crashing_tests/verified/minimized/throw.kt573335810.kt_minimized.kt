fun testImplicitCast(a: Any): Unit {
if (a is Throwable)({throw (((a))!! ?: (a))})
}