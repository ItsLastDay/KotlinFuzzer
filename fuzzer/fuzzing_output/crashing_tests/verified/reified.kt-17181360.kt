package test
inline fun <reified T : Any> className() = (T)?::class.java.className