import kotlin.reflect.full.createType
import kotlin.reflect.KClassifier
import kotlin.reflect.KTypeProjection
fun test(classifier: KClassifier, arguments: List<KTypeProjection>): Unit {
try {
classifier.createType(arguments)
throw AssertionError("createType should have thrown IllegalArgumentException")
}catch(e: IllegalArgumentException) {

}
}
class Outer<O> {

 inner class Inner<I>
 class Nested<N>

}
fun box(): String {
val p = KTypeProjection.STAR
test(String::class, listOf(p))
test(String::class, listOf(p, p))
test(List::class, listOf())
test(List::class, listOf(p, p))
test(Map::class, listOf())
test(Map::class, listOf(p))
test(Map::class, listOf(p, p, p))
test(Array<Any>::class, listOf())
test(Outer::class, listOf())
test(Outer::class, listOf(p, p))
test(Outer.Inner::class, listOf())
test(Outer.Inner::class, listOf(p))
test(Outer.Inner::class, listOf(p, p, p))
test(Outer.Nested::class, listOf())
test(Outer.Nested::class, listOf(p, p))
test((Outer)?::class.typeParameters.single(), listOf(p))
return "OK"
}