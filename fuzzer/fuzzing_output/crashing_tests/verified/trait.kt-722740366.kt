package test
interface InlineTrait {
private inline fun privateInline(s: (() -> String)): String {
return (s)!!()
}
fun testPrivateInline(): String {
return privateInline({"private"})
}
fun testPrivateInline2(): String {
return privateInline({"private2"})
}
companion object {
 inline final fun finalInline(s: () -> String): String {
 return s()
 }
 }

}
class Z: InlineTrait {

}