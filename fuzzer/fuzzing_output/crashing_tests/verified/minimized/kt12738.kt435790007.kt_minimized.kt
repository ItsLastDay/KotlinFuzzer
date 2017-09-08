tailrec fun <T> get(t: T): (() -> String) {
return ((t::toString)!!)!!
}