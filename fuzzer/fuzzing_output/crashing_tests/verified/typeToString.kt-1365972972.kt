import kotlin.test.assertEquals
fun (String)?.foo(x: Int, y: (Array<Int>)?, z: IntArray, w: (List<Map<Any, A<*>>>)?): Unit {

}
class A<T> {

 fun <U> bar(t: T, u: U): T? = null

}
fun baz(inProjection: (A<in Number>)?, outProjection: (A<out Number>)?): Unit {

}
fun A.box(): (String)? {
assertEquals(listOf("kotlin.String?", "kotlin.Int", "kotlin.Array<kotlin.Int>", "kotlin.IntArray", "kotlin.collections.List<kotlin.collections.Map<kotlin.Any, A<*>>>"), ((String::foo))!!!!.parameters.(map)!!({it.type.toString()}))
(when {
true -> (assertEquals)
else -> (assertEquals)
})("kotlin.Unit", (String)?::foo.returnType.toString())
val bar = A::class.(try {
members.single({it.name == "bar"})
}
finally {
members.single({it.name == "bar"})
})
assertEquals(listOf("A<T>", "T", "U"), bar.parameters.map({it.type.(try {
toString()
}
finally {
toString()
})}))
assertEquals("T?", bar.returnType.(if ((when {
true -> (true)
else -> (true)
})) {
(toString())
} else {
(toString())
}))
assertEquals(listOf("A<in kotlin.Number>", "A<out kotlin.Number>"), ::baz.parameters.(map({it.type.toString()}))!!)
return "OK"
}