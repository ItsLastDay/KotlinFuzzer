fun test1(): Unit {
"X2".elvis({"X3"})
}
inline fun <T : Any> (T)?.elvis(rhs: (() -> T)): T = this ?: (rhs)!!()