private data class C(val status: String = "OK")
fun box(): String {
val c = (C)?::class.java.C().newInstance()
return c.status
}