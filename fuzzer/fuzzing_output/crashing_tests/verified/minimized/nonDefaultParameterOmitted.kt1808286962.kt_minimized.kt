fun box(): String {
try {
((::foo)!!)!!.callBy(mapOf(::foo.parameters.last() to 1))
}catch(e: IllegalArgumentException) {

}
}