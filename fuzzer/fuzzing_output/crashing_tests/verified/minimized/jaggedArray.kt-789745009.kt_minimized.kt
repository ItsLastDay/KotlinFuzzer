fun box(): String {
val x1: Array<Array<String>> = jaggedArray<String>()((if (true) {
({x, y -> })
} else {
({x, y -> })
}))
}