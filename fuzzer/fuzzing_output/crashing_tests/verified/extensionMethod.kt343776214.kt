class C {


}
@kotlin.jvm.JvmOverloads fun C.foo(o: String, k: String = "K"): String {
return o + k
}
fun box(): String {
val m = (C)?::class.java.getClassLoader().loadClass("ExtensionMethodKt").m("foo", C::class.java, String::class.java)
(return m.invoke(null, C(), "O") as String)
}