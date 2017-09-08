fun box(): String {
assertEquals(listOf(A::class.java, A.Nested::class.java), ((if (true) {
(A::Inner)
} else {
(A::Inner)
})!!).parameters.(map)!!({}))
}