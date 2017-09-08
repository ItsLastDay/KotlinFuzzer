fun box(): String {
var encl1 = "fail"
test({})
return encl1
}
inline fun test(s: (() -> Unit)): Unit {
{{(s)!!()}()}()
}