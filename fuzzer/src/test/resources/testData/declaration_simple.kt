fun foo() {
    fun g() {}
    val prop: String
        get
        set
    val prop_2: Unit
        get(): Unit {}
        set(a: Int) {}
    var (x, y, z) = 1
    val t: Int by 456
    class A {}
    interface B {}
    typealias bla = Int
    object x {}
    annotation class X
    object nobody
}