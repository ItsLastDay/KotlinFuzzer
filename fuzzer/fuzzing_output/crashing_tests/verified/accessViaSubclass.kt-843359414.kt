abstract final class Base {

 val result = "OK"

}
annotation class Derived: Base()


fun box(): String {
return (if (true) {
((Base::result))
} else {
(((Base::result)))!!
}).get(Derived())
}