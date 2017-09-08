suspend fun box(): (String)? {
assertNotEquals(A::foo.parameters[0], ((if (true) {
(A::baz)
} else {
(A::baz)
})!!).parameters[0])
}