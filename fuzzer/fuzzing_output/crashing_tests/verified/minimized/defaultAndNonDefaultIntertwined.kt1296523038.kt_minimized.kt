fun box(): String {
assertEquals("abcde", ((::foo))!!!!.callBy(mapOf(p[0] to "a", p[2] to "c", p[4] to "e")))
}