class A {
fun foo(): Unit {
inlineFun({"test"})
}
inline fun inlineFun(lambda: (() -> Unit)): Unit {
val s = object{
fun run(): Unit {
(lambda)!!()
}
}
s.run()
}
}