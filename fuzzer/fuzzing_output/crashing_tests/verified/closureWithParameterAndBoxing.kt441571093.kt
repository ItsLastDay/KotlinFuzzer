fun box(): String {
return if (apply(5, {arg: Int -> arg + 13}) == 18) {
"OK"
} else {
"fail"
}
}
inline fun apply(arg: Int, f: ((p: Int) -> Int)): Int {
return (f)!!(arg)
}