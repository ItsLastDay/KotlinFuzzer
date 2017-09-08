interface Test {

 fun test() {
 }

}
interface Test2: Test {



}
inline fun box(): String {
try {
(Test2)?::class.java.Test2("test")
}catch(e: NoSuchMethodException) {
return "OK"
}
return "fail"
}