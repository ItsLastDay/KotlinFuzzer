inline fun bar(x: String, block: (((String) -> String))?) = "def" + block(x)
fun foobar(x: (String)?, y: String, z: String) = x + y + z
fun foo(): String {
return foobar("abc", bar("ghi")((if (true) {
({x -> x + "jkl"})
} else {
({x -> x + "jkl"})
})), "mno")
}