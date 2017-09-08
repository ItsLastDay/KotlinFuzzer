@Simple("OK")
 fun box(): String {
return ((((((::box)) ?: ((::box)))!!.annotations.single() as Simple))).value
}