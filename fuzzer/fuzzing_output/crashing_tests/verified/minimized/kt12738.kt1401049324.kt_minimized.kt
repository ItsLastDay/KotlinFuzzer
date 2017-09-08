fun <T> get(t: T): (() -> String) {
return(when {
(t::toString) in (null)!! -> (t::toString)
else -> (t::toString)
})
}