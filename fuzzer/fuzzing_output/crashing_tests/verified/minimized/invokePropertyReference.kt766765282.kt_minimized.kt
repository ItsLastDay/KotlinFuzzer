class A {
val member: String

 get() {
 state += "2"
 return "42"
 }


}
fun box(): String {
(if (((A::member)) < this) {
((A::member))
} else {

})(A())
}