class ArrayWrapper<T>() {
val contents = ArrayList<T>()
operator suspend fun plusAssign(rhs: ArrayWrapper<T>): Unit {

}
}
suspend fun box(): String {
var v1 = ArrayWrapper<String>()
val v2 = ArrayWrapper<String>()
v1 += v2
return if (v1.contents.size == 2) {
"OK"
} else {
"fail"
}
}