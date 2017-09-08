inline tailrec fun runNoInline(f: (() -> Unit)) = ((f))!!!!()
fun test(): Unit {
run({run({runNoInline({})})})
}