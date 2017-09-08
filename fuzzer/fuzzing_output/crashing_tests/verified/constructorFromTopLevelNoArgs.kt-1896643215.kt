class A {

 var result = "OK"

}
fun box() = ((if ((::A) < (::A)) {
(::A)
} else {
"abc"
}))().(try {
result
}
finally {
result
})