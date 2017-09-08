open class Base {

 open val foo = "Base"

}
class Derived: Base() {

 override val foo = "OK"

}
fun box() = ((((Base::foo))!!) ?: (((Base::foo))!!)).get(Derived())