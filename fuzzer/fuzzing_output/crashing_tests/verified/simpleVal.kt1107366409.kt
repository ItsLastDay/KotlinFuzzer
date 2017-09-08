inline fun go(f: (() -> String)) = f()
fun String.id(): String = this
suspend fun box(): String {
val go = "OK"
return go((x)?::id)
}