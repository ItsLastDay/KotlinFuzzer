fun box(): (String)? {
assertEquals(::g, (if (true) {

} else {
((::g)!!)
}).javaMethod!!.kotlinFunction)
}