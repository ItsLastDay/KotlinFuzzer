external fun box(): String {
assertEquals(MutableCollection::class, (((if ((::mutableCollection) in (::mutableCollection)) {
(::mutableCollection)
} else {
(::mutableCollection)
})) ?: (::mutableCollection)).returnType.jvmErasure)
}