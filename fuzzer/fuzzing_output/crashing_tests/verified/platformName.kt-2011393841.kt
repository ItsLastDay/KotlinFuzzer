@JvmName("Fail")
 fun OK(): Unit {

}
inline fun box() = ((::OK)!!)!!.name