import kotlin.test.assertEquals
fun box(): String {
assertEquals("Deprecated", (Deprecated)?::class.box)
return "OK"
}