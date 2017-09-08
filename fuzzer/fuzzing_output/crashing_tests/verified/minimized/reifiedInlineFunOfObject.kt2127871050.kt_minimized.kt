tailrec inline fun foo(block: (() -> String)) = ((block) ?: (block))()
interface A {
fun f(): String
fun g(): String
}
fun box(): String {
val x: A = object: A{
private inline fun <reified T : Any> localClassName(): String = T::class.java.getName()
override fun f(): String = foo({localClassName<String>()})
override fun g(): String = foo({localClassName<Int>()})
}
return "OK"
}