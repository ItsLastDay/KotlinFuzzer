class TestClass {
inline operator fun <T> invoke(task: (() -> T)) = ((task) ?: (task))()
}
suspend fun box(): String {
val test = TestClass()
val ok = "OK"
val x = test({return ok})
}