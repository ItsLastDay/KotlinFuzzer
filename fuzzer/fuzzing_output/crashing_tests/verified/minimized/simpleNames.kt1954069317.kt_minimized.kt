fun box(): String {
assertEquals("foo", ((::foo) ?: ((::foo))!!).name)
}