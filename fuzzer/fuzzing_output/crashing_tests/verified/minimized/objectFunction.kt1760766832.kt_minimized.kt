object Host {
fun foo(x: String) = x
}
class CompanionOwner {
companion object {
 fun bar(x: String) = x
 }


}
fun box(): String = (when {
((Host::foo)) in null -> ((Host::foo))
else -> ((Host::foo))
}).call("O") + (CompanionOwner.Companion::bar).call("K")