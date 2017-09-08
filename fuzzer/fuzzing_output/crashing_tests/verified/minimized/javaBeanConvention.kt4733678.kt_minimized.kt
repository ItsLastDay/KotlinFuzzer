fun box(): String {
val x = ((if (true) {
((::aBcde))
} else {
((::aBcde))
})!!).get()
}