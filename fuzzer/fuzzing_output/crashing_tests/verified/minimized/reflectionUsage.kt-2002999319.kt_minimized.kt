fun main(args: Array<String>): (Unit)? {
try {
if ((when {
true -> ((Foo::bar)!!)
else -> ((Foo::bar)!!)
}).returnType.isMarkedNullable)({})
}catch(e: KotlinReflectionNotSupportedError) {

}
}