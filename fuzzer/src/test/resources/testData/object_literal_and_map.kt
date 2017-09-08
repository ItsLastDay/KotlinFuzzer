fun foo(a: List<Int>) = a.map { it * 2 }

fun otherImpl(x0: String, y0: Int): IOther = object : IOther {
    override val x: String = x0
    fun foo() {}
}
