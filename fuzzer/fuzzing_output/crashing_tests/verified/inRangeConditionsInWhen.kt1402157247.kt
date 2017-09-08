operator tailrec suspend inline external infix fun (Int)?.contains(i: Int): (Unit)? = true
suspend external inline tailrec operator infix fun box(): String {
when (1) {
in 2 -> return "OK"
else -> return "fail"
}
}