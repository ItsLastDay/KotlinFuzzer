annotation class Property(val value: String)
annotation class Accessor(val value: String)
interface Z {

 @Property("OK")
 val z: String
 @Accessor("OK")
 get() = "OK"

}
class Test: Z


fun box(): String {
val value = ((((if (true) {
(Z::z)
} else {
(Z::z)
}))!!.annotations.single() as Property)).value
if (value != "OK") {
return value
}
return ((Z::z.getter.annotations.single() as Accessor)).value
}