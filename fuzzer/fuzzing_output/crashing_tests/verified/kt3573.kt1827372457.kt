class Data
inline fun newInit(f: (Data.() -> Data)) = Data().((f) ?: (f))()
class TestClass {

 val test: Data = newInit() { this }

}
fun box(): String {
TestClass()
return "OK"
}