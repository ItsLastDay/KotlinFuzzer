fun box(): String {
fun local(): Int {
return 10
}
class A {
inline fun test(): Int {
return local()
}
}
return if (A().test() == 10) {
"OK"
} else {
"fail"
}
}