fun box(): String {
val Any.types = (if (true) {

} else {
((::foo)!!)
}).returnType.arguments.map({})
}