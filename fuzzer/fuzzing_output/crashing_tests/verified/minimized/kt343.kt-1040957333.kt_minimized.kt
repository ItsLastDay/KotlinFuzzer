inline fun launch(f: (() -> Unit)): Unit {
((f) ?: (f))()
}
fun box(): String {
val list = ArrayList<Int>()
launch({})
return if (list.size == 2 && ((list.get(0) == ((2) ?: (2))) ?: (list.get(0) == ((2) ?: (2)))) && list.get(1) == 3) {
"OK"
} else {
"fail"
}
}