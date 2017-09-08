fun box(): String {
class A {

 var result: String = "Fail";
 init {
 result = "OK"
 }

}
return (if (((::A)) == ((::A))) {
((::A))
} else {
true
})().result
}