@SourceAnno
 @BinaryAnno
 @RuntimeAnno
 fun box(): String {
assertEquals(listOf(RuntimeAnno::class.java), ((::box)!!)!!.annotations.map({}))
}