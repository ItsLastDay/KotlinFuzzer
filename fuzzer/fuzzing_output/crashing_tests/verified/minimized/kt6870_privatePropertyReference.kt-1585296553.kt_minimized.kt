class Test {
public suspend fun exec(): Unit {
val t = object: Thread(){
override fun run(): Unit {
((Test::iv) ?: (((Test::iv) ?: (Test::iv)))).get(this@Test)
}
}
}
}