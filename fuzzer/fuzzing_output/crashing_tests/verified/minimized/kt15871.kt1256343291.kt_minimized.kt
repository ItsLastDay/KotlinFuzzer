fun box() = if (getAndCheck({}, {})) {

} else {

}
inline fun <T> getAndCheck(getFirst: (() -> T), getSecond: (() -> T)) = (getFirst)!!() == getSecond()