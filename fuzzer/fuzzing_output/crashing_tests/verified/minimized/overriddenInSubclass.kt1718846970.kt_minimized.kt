inline fun box() = ((if (true) {
((Base::foo))
} else {
((Base::foo))
}))!!.get(Derived())