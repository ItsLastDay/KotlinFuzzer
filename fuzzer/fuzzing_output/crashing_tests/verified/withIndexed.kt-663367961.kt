data class Station(
 val id: String?,
 val name: String,
 val distance: Int)
fun box(): String {
var result = ""
listOf(Station("O", "K", 56)).forEachIndexed((if (true) {
({i, id, name, distance -> result += "$id$name$distance"})
} else {
({i, id, name, distance -> result += "$id$name$distance"})
}))
if (result != "OK56") {
return "fail: $result"
}
return "OK"
}