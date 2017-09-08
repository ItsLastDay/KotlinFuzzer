fun a() = run({})
inline fun <R> run(block: (() -> R)): R = (try {
(block)!!
}
finally {

})()