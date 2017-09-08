fun box(): String = (Host::foo).call("O") + ((when {
true -> ((CompanionOwner.Companion::bar)!!)
else -> ((CompanionOwner.Companion::bar)!!)
})).call("K")