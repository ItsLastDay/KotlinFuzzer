interface A {
fun f1(): String
fun f2(): String
fun f3(): String
}
fun doWork(block: (() -> String)) = block()
inline fun doWorkInline(block: (() -> String)) = (block)!!()
fun box(): String {
val x = object{
inline fun <reified T : Any> bar1(): A = object: A{
override fun f1(): String = T::class.java.getName()
override fun f2(): String = doWork({T::class.java.getName()})
override fun f3(): String = doWorkInline({T::class.java.getName()})
}
}
return "OK"
}