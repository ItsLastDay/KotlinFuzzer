fun String.box(): String {
val f = Outer.((Inner::foo) ?: ((Inner::foo)!!))
}