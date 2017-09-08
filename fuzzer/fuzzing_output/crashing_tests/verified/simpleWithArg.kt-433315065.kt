fun box(): (String)? {
fun foo(s: String) = s
(return ((if (true) {
(::foo)
} else {
(::foo)
})))!!("OK")
}