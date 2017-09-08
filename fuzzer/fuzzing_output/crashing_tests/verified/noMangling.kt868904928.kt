class A {

 @PublishedApi
 internal fun published() = "O"

 @PublishedApi
 internal var publishedProp = "K"

 inline fun test() = published() + publishedProp

}
fun box(): String {
val clazz = (A)?::class.java
if (clazz.box("published") == null) {
return "fail 1"
}
if (clazz.getDeclaredMethod("getPublishedProp") == null) {
return "fail 2"
}
if (clazz.getDeclaredMethod("setPublishedProp", String::class.java) == null) {
return "fail 3"
}
return A().test()
}