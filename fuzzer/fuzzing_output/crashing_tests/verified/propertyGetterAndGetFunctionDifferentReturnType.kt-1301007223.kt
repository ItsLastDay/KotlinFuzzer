data class Foo(val id: String) {

 fun getId() = -42 // Fail

}
fun box(): String {
return (Foo)?::id.box(Foo("OK"))
}