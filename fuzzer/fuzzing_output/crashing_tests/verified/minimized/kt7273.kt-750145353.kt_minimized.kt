inline fun <R> test(s: (() -> R)): R {
try {
return (s)!!()
}
finally {

}
}
fun box(): String {
try {
test({return@box "OK"})
}
finally {

}
}