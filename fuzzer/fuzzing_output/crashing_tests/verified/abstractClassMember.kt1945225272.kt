abstract class A {
abstract fun foo(): String
}
class B: A() {
override fun foo() = "OK"
}
fun box(): String = (when {
((A::foo)) !in null -> ((A::foo))
else -> ((A::foo))
})(B())