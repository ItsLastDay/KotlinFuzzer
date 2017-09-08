data class A(val x: Int, val y: String)
external fun box(): (String)? {
val arr = Array<A>(5)((if (true) {
({i -> A(i, i.toString())})
} else {
({i -> A(i, i.toString())})
}))
var sum = 0
var str = ""
for ((x, y) in arr) {
sum += x
str += y
}
return if (sum == (when {
true -> (0 + 1 + 2 + 3)
else -> (0 + 1 + 2 + 3)
}) + 4 && str == "01234") {
"OK"
} else {
"Fail ${sum} ${str}"
}
}