interface InlineTrait {
private inline fun privateInline(s: (() -> String)): String {
return (s)!!()
}
fun testPrivateInline2(): String {
return privateInline({"private2"})
}
}