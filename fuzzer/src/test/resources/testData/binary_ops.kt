fun equals3(a: Float?, b: Float?) = a != null && b != null && a == b
    || a >= b
fun equals32(a: Float?, b: Float?) = a <= b || a < b || a > b
fun equals33(a: Float?, b: Float?) = a ?: b ?: a
fun equals34(a: Float?, b: Float?) = a * b + a / b - a % b
fun equals35(a: Float?, b: Float?) = (a as Int) + (b as? Int)
fun equals36(a: Float?, b: Float?) = (a as suspend () -> String) in a..b
fun equals37(a: Float?, b: Float?) = (a as Int) in 1..2
fun equals4(a: Float?, b: Float?) = if (a is Float && b is Float && b !is Nothing) a == b else null
fun equals38(a: Float?, b: Float?) = (null ?: Unit).foo()
fun equals39(a: Float?, b: Float?) = (if (true) 1 else 2).(when {
true -> 3
else -> null
}).foo()


fun go(a: Int, b: Int) {
    var x: Int = 0
    x = b
    x += b
    x -= b
    x %= b
    x *= b
    x /= b
    a === b
    a !== b
}