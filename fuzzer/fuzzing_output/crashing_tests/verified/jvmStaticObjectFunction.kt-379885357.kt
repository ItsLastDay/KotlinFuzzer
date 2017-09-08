import kotlin.reflect.*
object Host {

 @JvmStatic fun foo(x: String) = x

}
class CompanionOwner {

 companion object {
 @JvmStatic fun bar(x: String) = x
 }

}
fun box(): String = Host::foo.call("O") + box.(Companion)?::bar.call("K")