inline fun doCall(f: (() -> Any)) = (f)!!()
fun test2(): String {
val localResult = doCall({})
return "Hmmm .. ."
}