class A<T>(val t: T) {

 fun foo(): T = t

}
suspend fun box() = (((A<String>::foo))!!!!)(A("OK"))