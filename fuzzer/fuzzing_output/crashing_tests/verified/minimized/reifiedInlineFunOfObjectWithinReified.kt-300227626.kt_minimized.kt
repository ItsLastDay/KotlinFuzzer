inline fun foo(block: (() -> String)) = ((block) ?: (block))()
inline fun <reified T : Any> className(): String = T::class.java.getName()
interface A {
fun f(): String
fun g(): String
}
inline fun <reified T1 : Any, reified T2 : Any> AFactory(): A = object: A{
override fun f(): String = className<T1>()
override fun g(): String = foo({className<T2>()})
}