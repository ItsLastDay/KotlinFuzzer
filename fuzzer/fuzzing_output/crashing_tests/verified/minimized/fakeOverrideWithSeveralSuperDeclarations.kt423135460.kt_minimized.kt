interface D1 {

}
interface D2 {
fun foo(): Number
}
interface F3: D1, D2



open class D4 {
inline fun foo(): Int = 42
}
class F5: F3, D4()



fun box(): String {
val z = F5()
var result = z.foo()
return if (result == 5 * 42) {
"OK"
} else {
"Fail: $result"
}
}