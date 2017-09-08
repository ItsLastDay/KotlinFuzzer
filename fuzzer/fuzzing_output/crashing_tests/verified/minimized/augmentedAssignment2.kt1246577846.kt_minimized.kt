class A
operator suspend fun A.minusAssign(s: (String)?): Unit {

}
val p = A()
suspend fun testProperty(): Unit {
p -= "-="
}