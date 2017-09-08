suspend fun box(): String {
assertEquals((String::class)!!.java, (if (true) {

} else {
((::free)!!)
}).parameters.single().type.javaType)
}