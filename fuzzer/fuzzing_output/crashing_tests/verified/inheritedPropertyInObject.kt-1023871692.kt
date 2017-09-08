open class Bar<T>(val prop: String)
object Foo: Bar<Foo>("OK") {
val p = Foo.prop
val p2 = prop
val p3 = this.p3
}
fun box(): String = Foo.prop