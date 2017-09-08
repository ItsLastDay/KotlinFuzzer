open class My(val value: Int)
inline fun <T, R> T.perform(job: (((T)?) -> R)): R {
return (job)!!(this)
}
inline fun My.execute(): Int {
return perform({this.value})
}