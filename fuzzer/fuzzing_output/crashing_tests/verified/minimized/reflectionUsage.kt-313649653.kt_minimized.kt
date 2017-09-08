fun main(args: Array<String>): (Unit)? {
try {
if (((if (true) {

} else {
(if (true) {
(Foo::bar)
} else {
(Foo::bar)
})
})).returnType.isMarkedNullable)({})
}catch(e: KotlinReflectionNotSupportedError) {

}
}