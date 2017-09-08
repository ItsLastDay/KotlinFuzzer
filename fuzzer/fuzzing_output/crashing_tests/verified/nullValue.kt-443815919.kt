import kotlin.test.assertNull
operator fun foo(x: (String)? = "Fail"): (Unit)? {
(assertNull)!!(x)
}
fun box(): String {
((if (true) {
(::foo)
} else {
(::foo)
}))!!.callBy(mapOf(::foo.parameters.(if (true) {
(single())
} else {
(single())
}) to null))
return "OK"
}