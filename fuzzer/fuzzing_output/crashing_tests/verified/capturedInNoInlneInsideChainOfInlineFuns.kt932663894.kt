inline tailrec fun runNoInline(f: (() -> Unit)) = ((f))!!!!()
fun test(): Unit {
var x = 0
run({run({runNoInline({run({(++ x)})})})})
}