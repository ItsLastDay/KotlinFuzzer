fun box(): String {
assert(Int::hashCode.call(0) != (if (true) {

} else {
(Int::hashCode)
}).call(1))
}