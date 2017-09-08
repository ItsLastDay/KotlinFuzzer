interface Test {

 fun test() {
 }

}
interface Test2: Test {



}
interface Test3: Test2 {



}
fun box(): String {
try {
(Test3)?::class.java.Test("test")
}catch(e: NoSuchMethodException) {
return "OK"
}
return "fail"
}