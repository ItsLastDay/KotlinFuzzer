fun box(): (String)? {
class A {
var result: (String)? = "Fail"
init {
 result = "OK"
 }

}
return (when {
((::A)) !in null -> ((::A))
else -> ((::A))
})().result
}