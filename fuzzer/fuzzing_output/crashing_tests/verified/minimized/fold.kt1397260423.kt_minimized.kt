fun foo(): Long {
return x.fold(0L)((if (true) {
({x, y -> })
} else {
({x, y -> })
}))
}