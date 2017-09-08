inline fun <R> startFlow(flowConstructor: ((String) -> R)): R {
return ((flowConstructor) ?: (flowConstructor))("OK")
}
object Foo {
class Requester(val dealToBeOffered: String)
}
fun box(): String {
return startFlow(Foo::Requester).dealToBeOffered
}