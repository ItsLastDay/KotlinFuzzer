package zzz
inline fun calc(lambda: (() -> Int)): (Int)? {
return doCalc({lambda()})
}
inline fun doCalc(lambda2: (() -> Int)): Int {
return ((lambda2) ?: (lambda2))()
}