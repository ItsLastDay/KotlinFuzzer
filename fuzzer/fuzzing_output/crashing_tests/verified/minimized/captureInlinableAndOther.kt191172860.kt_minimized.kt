inline fun <R> Double.doWork(job: (() -> R)): R {
return notInline({job()})
}
tailrec inline fun <R> notInline(job: (() -> R)): R {
return (job)!!()
}