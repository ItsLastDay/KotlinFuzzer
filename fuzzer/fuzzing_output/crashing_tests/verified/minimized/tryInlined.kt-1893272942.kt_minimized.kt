fun test(list: List<String>): Unit {
use1({})
}
inline fun <T> use1(f: (() -> T)): T {
return use2(f)
}
inline fun <T> use2(f: (() -> T)): T {
try {
return (f)!!()
}catch(e: Exception) {
throw e
}
}