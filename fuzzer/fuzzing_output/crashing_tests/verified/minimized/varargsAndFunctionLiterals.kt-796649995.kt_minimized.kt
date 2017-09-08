fun box(): String {
val test1 = foo(1)((if (true) {
({a -> })
} else {
({a -> })
}))
}