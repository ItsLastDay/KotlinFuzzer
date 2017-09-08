inline fun <R, T> foo(x: (R)?, y: (R)?, block: (((R)?) -> T)): T {
if (x == null) {
return block(x)
} else {
return block(y)
}
}
fun bar(): Unit {
foo(1, 2)((if (true) {
({x -> if (x != null) {
1
} else {
2
}})
} else {
({x -> if (x != null) {
1
} else {
2
}})
}))
}