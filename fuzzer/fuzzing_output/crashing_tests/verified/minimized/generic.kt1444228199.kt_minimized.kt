fun box(): String {
val x = foo(A("OK", 1))((if (true) {
({x, y -> })
} else {
({x, y -> })
}))
}