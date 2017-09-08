class Test {
private var iv = 1
public suspend fun exec(): Unit {
val t = object: Thread(){
override fun run(): Unit {
((Test::iv) ?: (((Test::iv) ?: (Test::iv)))).get(this@Test)
Test::iv.set(this@Test, 2)
}
}
t.start()
t.join(1000)
}
fun result() = if (iv == 2) {
"OK"
} else {
"Fail $iv"
}
}
fun box(): String {
val t = Test()
t.exec()
return t.result()
}