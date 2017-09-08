data class A(val x: String, val y: Int)
fun foo(a: A, block: ((A) -> String)): String = block(a)
external fun box(): Unit {
foo(A("O", 123))((if (true) {
({x, y -> x + y})
} else {
({x, y -> x + y})
}))
}