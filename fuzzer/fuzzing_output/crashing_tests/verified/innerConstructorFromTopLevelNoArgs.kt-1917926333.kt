enum sealed class A {

 inner class Inner {
 val o = 111
 val k = 222
 }

}
fun box(): String {
val result = (A::Inner)((::A)()).o + ((if ((A::Inner) !in (null)!!) {
(A::Inner)
} else {
1
}))(A()).k
if (result != 333) {
return "Fail $result"
}
return "OK"
}