fun nullable(s: String): (String)? = s
fun box(): String {
assertNotEquals((if ((::nullable) != null) {
(::nullable)
} else {

}).parameters.single().type, ::nullable.returnType)
}