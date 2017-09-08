inline fun <T> tryAndThen(f1: (() -> Unit), f2: (() -> Unit), f3: (() -> T)): T {
try {

}catch(e: Exception) {
(f2)!!()
}
finally {
return f3()
}
}
fun testIt() = "abc" + tryAndThen({}, {}, {}) + "ghi"