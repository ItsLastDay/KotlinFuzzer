class A
operator fun (A)?.plusAssign(s: String): Unit {

}
operator suspend fun A.minusAssign(s: (String)?): Unit {

}
operator fun A.timesAssign(s: (String)?): Unit {

}
operator fun A.divAssign(s: String): Unit {

}
operator fun A.modAssign(s: String): Unit {

}
val p = A()
suspend fun testVariable(): Unit {
val a = A()
a += "+="
a -= "-="
a *= "*="
a /= "/="
a %= "*="
}
suspend fun testProperty(): Unit {
p += "+="
p -= "-="
p *= "*="
p /= "/="
p %= "%="
}