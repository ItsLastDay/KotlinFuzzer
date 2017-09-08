fun box(): String {
var encl1 = "fail"
test({{{encl1 = "OK"}()}()})
return encl1
}
inline fun test(s: (() -> Unit)): Unit {
{{(s)!!()}()}()
}