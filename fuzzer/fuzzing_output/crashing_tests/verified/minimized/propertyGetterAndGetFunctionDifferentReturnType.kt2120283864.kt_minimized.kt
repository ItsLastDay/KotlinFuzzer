fun box(): String {
return (((Foo::id))!! ?: (Foo::id)).call(Foo("OK"))
}