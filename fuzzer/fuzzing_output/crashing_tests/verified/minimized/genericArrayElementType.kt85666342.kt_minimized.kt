operator fun box(): String {
assertEquals(Bar::class.java, ((::arrayOfInvBar)!!)!!.returnType.arguments.single().type!!.javaType)
}