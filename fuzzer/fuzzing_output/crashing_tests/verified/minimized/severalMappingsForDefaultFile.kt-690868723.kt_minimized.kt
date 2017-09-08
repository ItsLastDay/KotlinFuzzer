inline fun annotatedWith2(predicate: (() -> Boolean)) = {any({(predicate)!!()})}()
inline fun annotatedWith(predicate: (() -> Boolean)) = annotatedWith2({predicate()})
inline fun any(s: (() -> Boolean)): Unit {
s()
}