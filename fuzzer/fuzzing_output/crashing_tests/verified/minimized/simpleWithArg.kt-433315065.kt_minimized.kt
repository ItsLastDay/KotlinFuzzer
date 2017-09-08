fun box(): (String)? {
fun foo(s: String) = s
(return((if (true) {

} else {
(::foo)
})))!!("OK")
}