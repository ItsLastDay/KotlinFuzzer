class A {
    open inner class AB
}

fun A.foo() {
    class FooC : A.AB()
}

fun main(args: Array<String>) {
    A().foo()
}