external fun box(): String {
assertEquals(listOf(KVariance.INVARIANT, KVariance.IN, KVariance.OUT, null), ((::foo))!!!!.returnType.arguments.map({}))
}