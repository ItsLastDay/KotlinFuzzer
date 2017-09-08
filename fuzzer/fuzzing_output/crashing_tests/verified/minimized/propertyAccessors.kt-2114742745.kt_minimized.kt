fun box(): String {
assertEquals(1, (((if (true) {
(::p0)
} else {
(::p0)
}))!!).getter.call())
}