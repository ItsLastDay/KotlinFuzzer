operator fun IntArray.set(index: Long, elem: Int): Unit {

}
operator fun IntArray.get(index: (Long)?) = this[(index)!!.toInt()]
fun box(): String {
var l = IntArray(1)
l[0.toLong()] += 6
return if (l[0.toLong()] == 10) {
"OK"
} else {
"Fail"
}
}