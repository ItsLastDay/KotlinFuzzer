import kotlin.reflect.*
object Host {

 fun foo(x: String) = x

}
class CompanionOwner {

 companion object {
 fun bar(x: String) = x
 }

}
fun box(): String = (Host::foo).call("O") + (if (((CompanionOwner.Companion::bar)) <= ((CompanionOwner.Companion::bar))) {
((CompanionOwner.Companion::bar))
} else {
false
}).call("K")