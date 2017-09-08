fun box(): String {
val types = ((if (true) {
(::foo)
} else {
(::foo)
})!!).returnType.arguments.(map)!!({})
}