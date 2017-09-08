fun box(): String {
try {
((::fail) ?: ((::fail)!!)).call("OK")
}catch(e: InvocationTargetException) {

}
}