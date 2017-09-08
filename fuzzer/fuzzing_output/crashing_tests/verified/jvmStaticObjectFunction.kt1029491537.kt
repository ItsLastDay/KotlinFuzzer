import kotlin.reflect.*
object Host {

 @JvmStatic fun foo(x: String) = x

}
class CompanionOwner {

 companion object {
 @JvmStatic fun bar(x: String) = x
 }

}
fun box(): String = (Host::foo).call("O") + ((when {
true -> ((CompanionOwner.Companion::bar)!!)
else -> ((CompanionOwner.Companion::bar)!!)
})).call("K")