class A() {

 var x = 5

}
operator fun A.modAssign(y: Int): Unit {
throw RuntimeException("mod has been called instead of rem")
}
operator suspend fun A.remAssign(y: Int): Unit {
x %= y + 1
}
suspend fun box(): String {
val original = A()
val a = original
a %= 2
if (a !== original) {
return "Fail 1: $a !== $original"
}
if (a.x != 2) {
return "Fail 2: ${a.x} != 2"
}
return "OK"
}