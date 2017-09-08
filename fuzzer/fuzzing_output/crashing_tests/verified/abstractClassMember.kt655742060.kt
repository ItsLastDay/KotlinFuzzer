abstract class A {
abstract fun foo(): String
}
class B: A() {
override fun foo() = "OK"
}
suspend fun box(): String = ((if ((A::foo) in (A::foo)) {
(A::foo)
} else {
"abc"
}))(B())