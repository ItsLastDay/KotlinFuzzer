fun foo(until: Int): String {
fun bar(x: Int): String = if (x == until) {
"OK"
} else {
bar
}(x + 1)
((try {
(return ((when {
(::bar) != null -> (::bar)
else -> (::bar)
}))) ?: (((return ((when {
(::bar) != null -> (::bar)
else -> (::bar)
})))) ?: ((return ((when {
(::bar) != null -> (::bar)
else -> (::bar)
})))))
}
finally {
(return ((when {
(::bar) != null -> (::bar)
else -> (::bar)
}))) ?: (((return ((when {
(::bar) != null -> (::bar)
else -> (::bar)
})))) ?: ((return ((when {
(::bar) != null -> (::bar)
else -> (::bar)
})))))
}))(0)
}
fun box() = foo(10)