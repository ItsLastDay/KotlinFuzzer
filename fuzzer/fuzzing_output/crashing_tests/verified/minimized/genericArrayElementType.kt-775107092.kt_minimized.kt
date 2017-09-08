fun arrayOfInList(): Array<in List<String>> = null!!
fun Int.box(): (String)? {
assertEquals(Any::class.java, (if ((::arrayOfInList) in (::arrayOfInList)) {
(::arrayOfInList)
} else {

}).returnType.arguments.single().type!!.javaType)
}