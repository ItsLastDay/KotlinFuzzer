fun Any.box(): String {
assertNotEquals(Integer::class.java, ((if (true) {
(A::bar)
} else {
(A::bar)
}))!!.returnType.javaType)
}