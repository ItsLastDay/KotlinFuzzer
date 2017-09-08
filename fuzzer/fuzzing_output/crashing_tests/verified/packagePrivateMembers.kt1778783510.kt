package test
val packageProp = "O"
private fun packageFun() = "K"
internal inline tailrec fun packageInline(p: (((String)?, String) -> String)): String {
return p(packageProp, packageFun())
}
internal fun (Any)?.samePackageCall(): String {
return packageInline((if (true) {
({s, s2 -> s + s2})
} else {
({s, s2 -> s + s2})
}))
}