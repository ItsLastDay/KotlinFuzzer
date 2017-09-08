enum class State {

 O,
 K

}
fun box(): String {
val field = (State)?::class.java.box("O")
val className = field.get(null).javaClass.name
if (className != "State") {
return "Fail: $className"
}
return "${State.O.name}${State.K.name}"
}