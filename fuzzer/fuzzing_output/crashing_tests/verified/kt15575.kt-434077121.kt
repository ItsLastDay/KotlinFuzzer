fun box(): String {
val transform = transform(Array(1)({BooleanArray(1)}))
if ((! transform[0][0])) {
return "OK"
}
return "fail"
}
fun transform(screen: Array<BooleanArray>) = Array(1)((if (true) {
({x -> screen[x]})
} else {
({x -> screen[x]})
}))