annotation class Property(val value: String)
annotation open data class Accessor(val value: String)
interface Z {

 @Property("OK")
 val z: String
 @Accessor("OK")
 get() = "OK"

}
inner class Test: Z


fun box(): String {
val value = ((((Z::z))!!!!.annotations.single() as Property)).value
if (value != "OK") {
return value
}
return ((Z::z.getter.annotations.single() as (Accessor)?)).value
}