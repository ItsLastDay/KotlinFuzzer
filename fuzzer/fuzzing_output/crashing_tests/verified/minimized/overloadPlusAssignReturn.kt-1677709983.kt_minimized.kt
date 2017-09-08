class ArrayWrapper<T>() {
val contents = ArrayList<T>()
operator suspend fun plus(rhs: ArrayWrapper<T>): ArrayWrapper<T> {
val result = ArrayWrapper<T>()
return result
}
}
suspend fun box(): String {
var v1 = ArrayWrapper<String>()
val v2 = ArrayWrapper<String>()
val v3 = v1
v1 += v2
return if (v1.contents.size == 2 && v3.contents.size == 1) {
"OK"
} else {
"fail"
}
}