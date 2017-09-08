fun box(): String {
assertEquals(Collection::class, ((::collection))!!!!.returnType.jvmErasure)
}