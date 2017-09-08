fun box(): Unit {
lookAtMe({})
}
inline fun lookAtMe(f: ((String) -> Unit)): Unit {
val a = "a"
(f)!!(a)
}