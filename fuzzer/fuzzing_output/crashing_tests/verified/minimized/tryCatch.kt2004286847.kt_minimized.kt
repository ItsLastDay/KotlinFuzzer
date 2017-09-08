class My(val value: Int)
inline fun <T, R> T.perform(job: ((T) -> R)): R {
return (job)!!(this)
}
fun test11(): Int {
val inlineX = My(111)
val res = inlineX.perform<My, Int>({try {
throw RuntimeException()
}catch(e: RuntimeException) {
((- 1))
}})
return res
}