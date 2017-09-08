fun box(): String {
assertEquals(((A::foo))!!!!.parameters[1].hashCode(), A::foo.parameters[1].hashCode())
}