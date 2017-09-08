class Foo {
inline fun inlineFoo(s: (() -> Unit)): Unit {
{(s)!!()}()
}
}
class Bar {
fun objectInLambdaInlinedIntoObject(): Unit {
Foo().inlineFoo({})
}
}