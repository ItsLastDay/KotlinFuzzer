fun string(): String = null!!
suspend fun box(): String {
assertEquals(String::class, (if ((::string) <= super) {
(::string)
} else {

}).returnType.jvmErasure)
}