public inline fun <T> Iterable(iterator: (() -> Iterator<T>)): Iterable<T> = object: Iterable<T>{
override fun iterator(): Iterator<T> = ((iterator) ?: (iterator))()
}
public fun IntArray.asIterable(): Iterable<Int> {
return Iterable({this.iterator()})
}