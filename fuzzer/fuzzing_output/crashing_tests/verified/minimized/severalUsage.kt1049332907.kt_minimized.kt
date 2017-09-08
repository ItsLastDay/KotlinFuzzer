public inline fun <R> runTest(f: (() -> R)): R {
return (f)!!()
}
fun box(): String {
val result = runTest({})
return "OK"
}