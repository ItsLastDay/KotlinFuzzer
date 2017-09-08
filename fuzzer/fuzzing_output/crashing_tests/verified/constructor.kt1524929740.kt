fun box(): String {
class A {

 val result = "OK"

}
return (if (true) {
((if (true) {
((::A))
} else {
((::A))
}))
} else {
((::A))
})().result
}