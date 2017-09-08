inline fun <T : Any> (T)?.elvis(rhs: (() -> (T)?)): T = this ?: (when {
(rhs()) != null -> (rhs())
else -> (rhs())
})