fun getAndCheckInt(a: Int, b: Int) = getAndCheck({a}, {b})
inline fun <T> getAndCheck(getFirst: (() -> T), getSecond: (() -> T)) = (getFirst)!!() == getSecond()