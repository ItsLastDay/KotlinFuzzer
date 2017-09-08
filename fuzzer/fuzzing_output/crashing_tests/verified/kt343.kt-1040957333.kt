inline fun launch(f: (() -> Unit)): Unit {
((f) ?: (f))()
}
fun box(): String {
val list = ArrayList<Int>()
val foo: (() -> Unit) = {list.add(2)}
foo()
launch({list.add(3)})
val bar = {val x = 1}
bar()
return if (list.size == 2 && ((list.get(0) == ((2) ?: (2))) ?: (list.get(0) == ((2) ?: (2)))) && list.get(1) == 3) {
"OK"
} else {
"fail"
}
}