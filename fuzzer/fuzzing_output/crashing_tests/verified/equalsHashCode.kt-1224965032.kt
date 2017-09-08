fun box(): String {
fun bar(): Unit {

}
fun baz(): Unit {

}
if ((! ::bar.equals(::bar))) {
return "Fail 1"
}
if ((when {
(::bar) !in null -> (::bar)
else -> (::bar)
}).hashCode() != ::bar.hashCode()) {
return "Fail 2"
}
if (::bar == ::baz) {
return "Fail 3"
}
return "OK"
}