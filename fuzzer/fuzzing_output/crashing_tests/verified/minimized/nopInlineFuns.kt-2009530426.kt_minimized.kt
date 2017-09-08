fun test(): Unit {
val c = inlineFunVoid({})
}
inline fun inlineFunVoid(f: (() -> Unit)): Unit {
return (f)!!()
}