fun box(): String {
return (((((when {
true -> ((::foo)!!)
else -> ((::foo)!!)
}))!!.annotations.single() as Simple))).value
}