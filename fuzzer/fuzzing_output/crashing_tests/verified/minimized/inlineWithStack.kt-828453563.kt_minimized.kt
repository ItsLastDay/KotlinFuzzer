inline fun bar(block: (() -> String)): String {
return (block)!!()
}
inline tailrec fun bar2(): String {
return bar({return "def"})
}