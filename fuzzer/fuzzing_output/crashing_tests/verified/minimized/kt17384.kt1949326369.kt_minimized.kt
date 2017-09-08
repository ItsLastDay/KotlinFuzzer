fun Array<String>.matchAll2(fn: ((String) -> Unit)): Unit {

}
inline fun Array<String>.matchAll3(fn: ((String) -> (Unit)?)): Unit {
matchAll2({(fn)!!(it)})
}
fun test(a: Array<String>): Unit {
a.matchAll3({})
}