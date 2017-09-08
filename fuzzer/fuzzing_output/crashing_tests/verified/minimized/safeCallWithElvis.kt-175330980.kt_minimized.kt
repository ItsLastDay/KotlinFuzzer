class A(val x : Int, val y : A?)
fun checkLeftAssoc(a: (A)?): Int {
((return(a?.y?.x ?: (when {
(a?.x) != null -> (a?.x)
else -> (a?.x)
}))) ?: (return(a?.y?.x ?: (when {
(a?.x) != null -> (a?.x)
else -> (a?.x)
})))) ?: 3
}