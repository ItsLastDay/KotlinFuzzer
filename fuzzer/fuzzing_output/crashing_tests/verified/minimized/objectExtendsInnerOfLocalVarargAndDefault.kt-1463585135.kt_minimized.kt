fun box(): String {
class Local {
open inner class Inner(val d: Double = -1.0, val s: String, vararg val y: Int) {
open fun result() = "Fail"
}
val obj = object: Inner(s = "OK"){
override inline fun result() = s
}
}
return Local().obj.result()
}