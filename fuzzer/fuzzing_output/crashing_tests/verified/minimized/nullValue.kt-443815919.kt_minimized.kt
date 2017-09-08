fun box(): String {
((if (true) {
(::foo)
} else {
(::foo)
}))!!.callBy(mapOf(::foo.parameters.(if (true) {

} else {

}) to null))
}