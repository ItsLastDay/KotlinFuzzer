import kotlin.reflect.*
class A<T> {

 val result = "OK"

}
fun box(): String {
val k: KProperty1<A<*>, *> = (A)?::class.A.single()
(return k.get(A<String>()) as String)
}