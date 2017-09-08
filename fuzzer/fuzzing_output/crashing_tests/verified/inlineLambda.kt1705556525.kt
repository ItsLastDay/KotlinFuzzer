package foo
class Foo {
inline fun inlineFoo(s: (() -> Unit)): Unit {
{(s)!!()}()
}
inline fun simpleFoo(s: (() -> Unit)): Unit {
s()
}
}
class Bar {
fun Bar.callToInline(): Unit {
Foo().inlineFoo({1})
}
fun objectInInlineLambda(): Unit {
val s = 1
Foo().simpleFoo({{s}()})
}
fun objectInLambdaInlinedIntoObject(): Unit {
val s = 1
Foo().inlineFoo({{s}()})
}
}