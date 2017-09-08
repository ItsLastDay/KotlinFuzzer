class A {
var result = "OK"
}
fun box() = (when {
((::A)) !in null -> ((::A))
else -> ((::A))
})().result