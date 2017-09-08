fun box(): Long {
val x2 = (1 .. 5).fold(0)((if (true) {
({x, y -> })
} else {
({x, y -> })
}))
}