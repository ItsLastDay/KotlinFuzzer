var state = ""
var topLevel: Int

 get() {
 state += "1"
 return 42
 }

set(value) {
 throw AssertionError("Nooo")
 }


data class A {

 val member: String
 get() {
 state += "2"
 return "42"
 }

}
val A.ext: Any

 get() {
 state += "3"
 return this
 }


fun box(): String {
((if (true) {
((::topLevel))
} else {
((::topLevel))
}))!!()
(A::member)(A())
((A::ext))!!(A())
return if (state == "123") {
"OK"
} else {
"Fail $state"
}
}