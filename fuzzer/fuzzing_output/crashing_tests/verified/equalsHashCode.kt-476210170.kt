fun box(): String {
fun bar(): Unit {

}
fun baz(): Unit {

}
if ((! ((if (true) {
(::bar)
} else {
(::bar)
}))!!.equals(::bar))) {
return "Fail 1"
}
if (::bar.hashCode() != ((::bar)!!.hashCode())!!) {
return "Fail 2"
}
if (::bar == ::baz) {
return "Fail 3"
}
return "OK"
}