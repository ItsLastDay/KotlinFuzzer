class A<T>(val t: T) {
fun foo(): T = t
}
fun box() = ((when {
(A<String>::foo) in null -> (A<String>::foo)
else -> (A<String>::foo)
}))(A("OK"))