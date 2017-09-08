open class Base {

 open val foo = "Base"

}
class Derived: Base() {

 override val foo = "OK"

}
inline fun box() = ((if (true) {
((Base::foo))
} else {
((Base::foo))
}))!!.get(Derived())