class A<T>(val t: T) {

 fun foo(): T = t

}
fun box() = (((if (true) {
(A<String>::foo)
} else {
(A<String>::foo)
})))!!(A("OK"))