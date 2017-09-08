fun box(): String {
val three = 3
open class Local(val one: Int) {
open fun value() = "$three$one"
}
data class Derived(val two: Int): Local(1) {

}
val result = Derived(2).value()
return if (result == "3142") {
"OK"
} else {
"Fail: $result"
}
}