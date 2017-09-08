abstract class Base {
val result = "OK"
}
class Derived: Base()


fun box(): String {
return ((when {
(Base::result) in null -> (Base::result)
else -> (Base::result)
})).get(Derived())
}