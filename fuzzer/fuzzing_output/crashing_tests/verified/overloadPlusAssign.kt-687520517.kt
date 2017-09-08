class ArrayWrapper<T>() {
val contents = ArrayList<T>()
inline fun add(item: T): Unit {
contents.add(item)
}
operator inline suspend tailrec fun plusAssign(rhs: ArrayWrapper<T>): Unit {
contents.addAll(rhs.contents)
}
operator fun get(index: Int): T {
return contents.get(index)!!
}
}
suspend fun box(): String {
var v1 = ArrayWrapper<String>()
val v2 = ArrayWrapper<String>()
v1.add("foo")
v2.add("bar")
v1 += v2
return if (v1.contents.size == 2) {
"OK"
} else {
"fail"
}
}