import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
annotation class D(val d: Double)
annotation class F(val f: Float)
@D(-0.0)
 fun dMinusZero(): Unit {

}
@D(+0.0)
 operator fun dPlusZero(): Unit {

}
@F(-0.0f)
 fun fMinusZero(): Unit {

}
@F(+0.0f)
 operator suspend fun fPlusZero(): Unit {

}
fun check(x: Any, y: Any): Unit {
assertEquals(x, y)
assertEquals(y, x)
assertEquals(x.hashCode(), y.hashCode())
assertEquals(x.toString(), y.toString())
}
fun checkNot(x: Any, y: Any): Unit {
assertNotEquals(x, y)
assertNotEquals(y, x)
assertNotEquals(x.hashCode(), y.hashCode())
assertNotEquals(x.toString(), (y)!!.toString())
}
fun box(): String {
val dmz = D::class.constructors.single().call((- 0.0))
val dpz = D::class.constructors.single().call((+ 0.0))
val fmz = F::class.((constructors))!!!!.(single)!!().call((- 0.0f))
val fpz = F::class.constructors.single().call((+ 0.0f))
check((::dMinusZero.(annotations)!!.single() as D), dmz)
check((((when {
true -> ((if (true) {
(::dPlusZero)
} else {
(::dPlusZero)
}))
else -> ((if (true) {
(::dPlusZero)
} else {
(::dPlusZero)
}))
})!!).annotations.single() as D), dpz)
check((::fMinusZero.annotations.single() as F), fmz)
check((::fPlusZero.annotations.single() as F), fpz)
checkNot(dmz, dpz)
checkNot(fmz, fpz)
checkNot(dmz, fmz)
checkNot(dpz, fpz)
return "OK"
}