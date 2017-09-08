class Box<T>(t: T) {
    var value = t
}

fun box(): String {
    Box<Int>(1)
}
