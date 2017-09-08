fun box(): Unit {
lookAtMe({val c = "c"})
}
inline fun lookAtMe(f: ((String) -> Unit)): Unit {
val a = "a"
(f)!!(a)
}