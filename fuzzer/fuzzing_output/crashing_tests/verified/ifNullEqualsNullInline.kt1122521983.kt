fun test1(): Unit {
val n = null
n.elvis({"X1"})
"X2".elvis({"X3"})
}
inline fun <T : Any> (T)?.elvis(rhs: (() -> T)): T = this ?: (rhs)!!()