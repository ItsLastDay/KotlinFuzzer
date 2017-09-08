fun box(): String {
var encl1 = "fail"
var encl2 = "fail"
test({{encl1 = "OK"
{encl2 = "OK"}()}()})
return "OK"
}
inline fun test(s: (() -> Unit)): Unit {
(s)!!()
}