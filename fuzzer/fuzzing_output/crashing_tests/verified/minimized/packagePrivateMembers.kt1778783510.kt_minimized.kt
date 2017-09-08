internal fun (Any)?.samePackageCall(): String {
return packageInline((if (true) {
({s, s2 -> })
} else {
({s, s2 -> })
}))
}