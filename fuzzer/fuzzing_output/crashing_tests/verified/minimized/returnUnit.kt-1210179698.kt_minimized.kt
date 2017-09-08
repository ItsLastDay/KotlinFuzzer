external fun box(): String {
assertEquals(null, ((if (true) {
((::nullableUnit))
} else {
((::nullableUnit))
})!!).call(false))
}