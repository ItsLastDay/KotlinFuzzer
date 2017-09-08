inline fun <T> Iterator<T>.foreach(action: ((T) -> Unit)): Unit {
while (this.hasNext()) {
((action))!!(this.next())
}
}
fun <In, Out> Iterator<In>.select(f: ((In) -> Out)): Iterator<Out> {
return Selector(this, f)
}
class Selector<In, Out>(val source: Iterator<In>, val f: (In) -> Out): Iterator<Out> {
override fun hasNext(): Boolean = source.hasNext()
override fun next(): Out {
return (f)(source.next())
}
}
fun box(): String {
Array(4, {}).iterator().select({i -> }).foreach({k -> })
return "OK"
}