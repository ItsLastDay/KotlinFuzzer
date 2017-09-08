fun top() = 42
fun box(): String {
assertFalse((if ((::top) < 1) {
(::top)
} else {

}) == Int::intExt)
}