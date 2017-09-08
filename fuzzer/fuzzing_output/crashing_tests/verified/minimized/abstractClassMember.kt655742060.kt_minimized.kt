abstract class A {
abstract fun foo(): String
}
suspend fun box(): String = ((if ((A::foo) in (A::foo)) {
(A::foo)
} else {

}))(B())