fun getAndCheckInt(a: Int, b: Int) = getAndCheck({}, {})
inline fun <T> getAndCheck(getFirst: (() -> T), getSecond: (() -> T)) = (getFirst)!!() == getSecond()