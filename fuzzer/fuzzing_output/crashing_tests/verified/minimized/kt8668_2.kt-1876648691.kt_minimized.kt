class Person(val name: String) {
fun sayName() = doSayName({name})
inline fun doSayName(call: (() -> String)): String {
return nestedSayName1({nestedSayName2({((call) ?: (call))()})})
}
inline fun nestedSayName1(call: (() -> String)) = call()
inline fun nestedSayName2(call: (() -> String)) = call()
}