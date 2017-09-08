fun box(): String {
assertEquals(Bar::class.java, ((::fooOfOutBar))!!!!.returnType.arguments.single().type!!.javaType)
}