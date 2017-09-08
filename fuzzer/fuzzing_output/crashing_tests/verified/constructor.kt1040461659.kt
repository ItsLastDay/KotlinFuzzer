fun box(): String {
class A {

 val result = "OK"

}
return ((if ((::A) != (::A)) {
(::A)
} else {
true
}))().result
}