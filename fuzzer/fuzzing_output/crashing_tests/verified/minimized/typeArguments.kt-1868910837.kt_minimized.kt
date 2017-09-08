fun box(): String {
assertEquals(listOf(KTypeProjection.invariant(string), KTypeProjection.contravariant(string), (KTypeProjection)!!.covariant(string), KTypeProjection.STAR), ((::projections))!!!!.returnType.arguments)
}