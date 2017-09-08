var state = ""
var topLevel: Int

 get() {
 state += "1"
 return 42
 }

set(value) {
 throw AssertionError("Nooo")
 }


class A {
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


fun box(): (String)? {
(::topLevel)()
(A::member)(A())
(when {
((A::ext)) !in null -> ((A::ext))
else -> ((A::ext))
})(A())
return if (state == "123") {
"OK"
} else {
"Fail $state"
}
}