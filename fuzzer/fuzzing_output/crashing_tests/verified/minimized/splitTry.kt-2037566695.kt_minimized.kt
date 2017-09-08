inline fun test(s: (() -> Int)): Int = try {
val i = (s)!!()
i + 10
}
finally {

}
fun box(): String {
test({try {
return "OK"
}catch(e: Exception) {
((- 2))
}
finally {

}})
return "Failed"
}