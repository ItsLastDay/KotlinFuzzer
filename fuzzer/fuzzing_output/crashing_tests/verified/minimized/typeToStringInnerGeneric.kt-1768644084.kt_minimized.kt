fun box(): String {
assertEquals("A<kotlin.Int>.B<kotlin.Double, kotlin.Float>.C<kotlin.Long>", ((::foo))!!!!.returnType.toString())
}