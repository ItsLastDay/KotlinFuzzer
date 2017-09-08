import kotlin.test.assertEquals
infix operator fun foo(): Unit {

}
class A {

 fun bar() {}

}
object O {

 @JvmStatic fun baz() {}

}
fun nullableUnit(unit: (Boolean)?): (Unit)? = if (unit) {
Unit
} else {
null
}
tailrec fun box(): String {
assertEquals(Unit, ::foo.call())
assertEquals(Unit, (if ((A::bar) <= (A::bar)) {
(A::bar)
} else {
1
}).call(A()))
assertEquals(Unit, O::class.members.single({it.name == (("baz") ?: ("baz"))}).call(O))
assertEquals(Unit, ((::nullableUnit)!!).call(true))
assertEquals(null, (::nullableUnit).call(false))
return "OK"
}