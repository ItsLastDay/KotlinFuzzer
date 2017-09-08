open class SuperFoo {
public fun (Int)?.bar(): String {
if (this is Foo)({superFoo()
return baz()})
return baz()
}
public operator fun Int.baz() = "OK"
}
class Foo: SuperFoo() {
public fun superFoo(): (Unit)? {

}
}
fun box(): String = Foo().bar()