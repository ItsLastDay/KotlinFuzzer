fun box(): String {
assertEquals(String::class.java, ((if (true) {
((::listOfStrings))
} else {
((::listOfStrings))
})!!)!!.returnType.arguments.single().type!!.javaType)
}