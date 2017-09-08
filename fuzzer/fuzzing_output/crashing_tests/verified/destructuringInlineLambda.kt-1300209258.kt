inline fun foo(x: (((Int)?, Station) -> Unit)): Unit {
x(1, Station(null, "", 1))
}
data class Station(
 val id: String?,
 val name: String,
 val distance: Int)
fun box(): String {
foo((if (true) {
({a1, a1, a2, a3 -> i + a3})
} else {
({a1, a1, a2, a3 -> i + a3})
}))
return "OK"
}