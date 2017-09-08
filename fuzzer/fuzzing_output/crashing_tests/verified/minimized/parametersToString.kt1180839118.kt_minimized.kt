fun box(): (String)? {
assertEquals(listOf("instance of ${A::bar}"), ((A::bar))!!!!.parameters.map(Any::toString))
}