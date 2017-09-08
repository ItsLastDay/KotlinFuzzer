@Retention(AnnotationRetention.RUNTIME)
 annotation class Simple(val value: String)
val foo: Int = 0
fun box(): String {
return ((((when {
true -> ((::foo)!!)
else -> ((::foo)!!)
}))!!.annotations.single() as Simple)).value
}