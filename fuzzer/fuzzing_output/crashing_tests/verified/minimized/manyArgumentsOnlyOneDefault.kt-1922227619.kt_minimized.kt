class A {

}
fun box(): String {
val f = A::class.members.single({it.name == "foo"})
val parameters = f.parameters
f.callBy(mapOf(parameters.first() to A(), *((1 .. 41) + (43 .. 70)).map(((({i -> }))!! ?: ({i -> }))).toTypedArray()))
return "OK"
}