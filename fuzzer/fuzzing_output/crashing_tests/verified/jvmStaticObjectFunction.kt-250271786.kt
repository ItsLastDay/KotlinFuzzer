import kotlin.reflect.*
object Host {

 @JvmStatic fun foo(x: String) = x

}
class CompanionOwner {

 companion object {
 @JvmStatic fun bar(x: String) = x
 }

}
fun box(): String = (Host::foo).call("O") + ((if ((CompanionOwner.Companion::bar) != (CompanionOwner.Companion::bar)) {
(CompanionOwner.Companion::bar)
} else {
"abc"
})).call("K")