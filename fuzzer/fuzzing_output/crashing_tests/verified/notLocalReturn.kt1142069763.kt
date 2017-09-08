inline tailrec fun doCall(f: (() -> Unit)) = (f)!!()
fun test1(nonLocal: String): String {
val localResult = doCall({return nonLocal})
return ("NON_LOCAL_FAILED $localResult")!!
}
fun doSomething(): Unit {

}
fun test2(): Unit {
fun f(x: (Any)?) = x
f(((when {
true -> (try {
null
}
finally {
null
})
else -> (try {
null
}
finally {
null
})
}))?.let({return}))
doSomething()
}
fun test3(x: (Any)?): Boolean = x?.let({return true}) ?: false