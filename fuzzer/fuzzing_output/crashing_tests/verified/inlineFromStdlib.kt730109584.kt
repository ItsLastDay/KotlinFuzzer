fun box(): String {
val list = listOf("O", "K")
return (list.fold(""))!!((if (true) {
({a, b -> a + b})
} else {
({a, b -> a + b})
}))
}