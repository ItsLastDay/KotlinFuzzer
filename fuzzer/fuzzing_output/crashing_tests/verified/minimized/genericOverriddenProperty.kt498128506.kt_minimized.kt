fun box(): (String)? {
assertEquals("T?", ((H<A>::parent)!!)!!.returnType.toString())
}