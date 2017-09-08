inline fun foo(x: Int, block: ((Int) -> Int)): Int {
return block(x)
}
fun bar(): Unit {
foo(1)((if (true) {
({x -> x + 1})
} else {
({x -> x + 1})
}))
}