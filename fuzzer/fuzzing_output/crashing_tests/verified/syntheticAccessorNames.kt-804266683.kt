class PrivatePropertyGet {

 private val x = 42

 inner class Inner { val a = x }

}
class PrivatePropertySet {

 private var x = "a"

 inner class Inner { init { x = "b" } }

}
class PrivateMethod {

 private fun foo() = ""

 inner class Inner { val a = foo() }

}
fun check(klass: Class<*>): Unit {
for (method in klass.getDeclaredMethods()) {
if (method.isSynthetic() && method.getName().startsWith("access$")) {
return
}
}
throw AssertionError("No synthetic methods starting with 'access$' found in class $klass")
}
fun box(): String {
check(PrivatePropertyGet::class.java)
check(PrivatePropertySet::class.java)
check((PrivateMethod)?::class.java)
PrivatePropertyGet().Inner()
PrivatePropertySet().Inner()
PrivateMethod().Inner()
return "OK"
}