package test
inline fun <R> Double.doWork(job: (() -> R)): R {
val k = 10
return notInline({k
job()})
}
tailrec inline fun <R> notInline(job: (() -> R)): R {
return (job)!!()
}