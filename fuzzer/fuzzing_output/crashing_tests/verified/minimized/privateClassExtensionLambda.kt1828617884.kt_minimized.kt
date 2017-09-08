private class S {
fun a(): String {
return "K"
}
internal inline fun call(s: (S.() -> String)): String {
return call2(s)
}
}
@Suppress("PRIVATE_CLASS_MEMBER_FROM_INLINE","EXPOSED_PARAMETER_TYPE","EXPOSED_RECEIVER_TYPE")
 internal inline fun S.call2(s: (S.() -> (String)?)): String {
return (s)!!() + a()
}
internal fun call(): String {
return S().call({"O"})
}