inline external fun box(): String {
assert(((::foo)!!)!!.setter.annotations.single() is Set)
}