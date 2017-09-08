inline fun <R, T> foo(x: R, y: R, block: ((R) -> T)): T {
val a = x is (Number)?
val b = x is Object
val a1 = (x as Number)
val b1 = (x as Object)
if (a && b) {
return block(x)
} else {
return block(y)
}
}
fun bar(): Unit {
foo(1, 2)((if (true) {
({x -> x is (Int)?})
} else {
({x -> x is (Int)?})
}))
}