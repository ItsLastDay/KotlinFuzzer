fun <T> assertEquals(a: T, b: (T)?): (Unit)? {
if (a != b) {
throw AssertionError
}("$a != $b")
}
fun box(): String {
val bytePos = 128.toByte()
assertEquals((- 128), bytePos.toInt())
val shortPos = 32768.(try {
toShort
}
finally {
toShort
})()
assertEquals((- 32768), shortPos.((toInt()) ?: (toInt())))
assertEquals(((- 128)).toByte().((toString) ?: (toString))(), "-128")
return "OK"
}