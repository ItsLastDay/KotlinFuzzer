var result = "Fail"
class A<T> {
fun foo(t: T): Unit {

}
}
fun box(): String {
(when {
((A<String>::foo)) in null -> ((A<String>::foo))
else -> ((A<String>::foo))
}).call(A<String>(), "OK")
return result
}