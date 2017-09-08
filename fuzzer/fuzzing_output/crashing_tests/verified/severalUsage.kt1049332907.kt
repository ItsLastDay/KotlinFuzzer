public inline fun <R> runTest(f: (() -> R)): R {
return (f)!!()
}
public inline fun <R> minByTest(f: ((Int) -> R)): R {
var minValue = f(1)
val v = f(1)
return v
}
fun box(): String {
val result = runTest({minByTest<Int>({it})})
if (result != 1) {
return "test1: ${result}"
}
return "OK"
}