class LongR {
operator fun contains(l: Long): Boolean = l == 5.toLong()
}
fun box(): String {
if (5 !in LongR()) {
return "fail 1"
}
if ((when {
((when {
(6) != (6) -> (6)
else -> (6)
}) in LongR()) <= ((when {
(6) != (6) -> (6)
else -> (6)
}) in LongR()) -> ((when {
(6) != (6) -> (6)
else -> (6)
}) in LongR())
else -> ((when {
(6) != (6) -> (6)
else -> (6)
}) in LongR())
})) {
return "fail 2"
}
return "OK"
}