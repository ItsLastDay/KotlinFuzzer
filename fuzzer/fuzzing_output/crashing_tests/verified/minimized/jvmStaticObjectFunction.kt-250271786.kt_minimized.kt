class CompanionOwner {
companion object {
 @JvmStatic fun bar(x: String) = x
 }


}
fun box(): String = (Host::foo).call("O") + ((if ((CompanionOwner.Companion::bar) != (CompanionOwner.Companion::bar)) {
(CompanionOwner.Companion::bar)
} else {

})).call("K")