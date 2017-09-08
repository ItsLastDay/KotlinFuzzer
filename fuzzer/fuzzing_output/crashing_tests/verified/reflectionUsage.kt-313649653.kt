class Foo(val bar: String?)
fun main(args: Array<String>): (Unit)? {
try {
if (((if (true) {
((when {
true -> (if (true) {
(Foo::bar)
} else {
(Foo::bar)
})
else -> (if (true) {
(Foo::bar)
} else {
(Foo::bar)
})
}))
} else {
(if (true) {
(Foo::bar)
} else {
(Foo::bar)
})
})).returnType.isMarkedNullable)({print("Foo#bar is nullable")})
}catch(e: KotlinReflectionNotSupportedError) {
print("no reflection")
}
}