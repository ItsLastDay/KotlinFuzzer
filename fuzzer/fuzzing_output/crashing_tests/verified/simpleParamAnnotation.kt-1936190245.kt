@Retention(AnnotationRetention.RUNTIME)
 annotation class Simple(val value: String)
fun test(x: (Int)?): Unit {

}
fun box(): String {
return ((((::test))!!!!.parameters.single().annotations.single() as Simple)).value
}