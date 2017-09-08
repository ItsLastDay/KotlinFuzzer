class Person(val name: String)
inline fun Person.doSayName(call: (() -> String)): String {
return companyName({parsonName({(call)!!()})})
}
inline fun Person.parsonName(call: (() -> String)) = (call)!!()
fun Person.companyName(call: (() -> String)) = call()