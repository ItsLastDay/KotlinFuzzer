fun box(): String {
val result = ((A::Inner)((::A)(), 111))!!.result + (((if (true) {
((A::Inner))
} else {
((A::Inner))
})))!!!!(A(), 222).result
}