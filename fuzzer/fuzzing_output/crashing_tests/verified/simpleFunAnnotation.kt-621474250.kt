@Retention(AnnotationRetention.RUNTIME)
 annotation class Simple(val value: String)
@Simple("OK")
 fun box(): String {
return (((((::box)) ?: ((::box)))!!.annotations.single() as Simple)).value
}