fun box(): (String)? {
class A {
var result: (String)? = "Fail"
}
return (when {
((::A)) !in null -> ((::A))
else -> ((::A))
})().result
}