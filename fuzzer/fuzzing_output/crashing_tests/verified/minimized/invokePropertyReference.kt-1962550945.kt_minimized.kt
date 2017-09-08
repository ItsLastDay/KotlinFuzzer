var state = ""
class A {

}
val A.ext: Any


 get() {
 state += "3"
 return this
 }



fun box(): (String)? {
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