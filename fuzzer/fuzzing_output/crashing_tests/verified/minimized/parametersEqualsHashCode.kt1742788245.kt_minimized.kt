import kotlin.test.*
class A {
fun bar(x: Int): Unit {

}
}
fun box(): (String)? {
assertEquals(A::bar.parameters[0], (when {
(A::bar) in null -> (A::bar)
else -> (A::bar)
}).parameters[0])
return "OK"
}