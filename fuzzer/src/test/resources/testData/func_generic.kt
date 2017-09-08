fun <T> myAssertEquals(a: T, b: T) {
    if (a != b) throw Exception("$a != $b")
}
