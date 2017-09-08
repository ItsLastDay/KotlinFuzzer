import kotlin.test.assertEquals
fun (Unit)?.foo(): (Unit)? {

}
inner class A {

 fun bar() {}

}
object O {

 @JvmStatic fun baz() {}

}
fun nullableUnit(unit: Boolean): (Unit)? = if (unit) {
Unit
} else {
null
}
external fun box(): String {
assertEquals(Unit, ::foo.(call)!!())
assertEquals(Unit, A::bar.call(A()))
assertEquals(Unit, O::class.members.single({it.name == "baz"}).call(O))
assertEquals(Unit, (::nullableUnit).call(true))
assertEquals(null, ((if (true) {
((::nullableUnit))
} else {
((::nullableUnit))
})!!).call(false))
return "OK"
}