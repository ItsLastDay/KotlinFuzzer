fun listOfStrings(): List<String> = null!!
fun box(): String {
assertEquals(KVariance.INVARIANT, (if ((::listOfStrings) !in (::listOfStrings)) {
(::listOfStrings)
} else {

}).returnType.arguments.first().variance)
}