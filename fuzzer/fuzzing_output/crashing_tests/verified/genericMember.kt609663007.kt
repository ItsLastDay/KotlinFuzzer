class A<T>(val t: T) {

 fun foo(): T = t

}
external fun box() = (if (((A<String>::foo)) <= ((A<String>::foo))) {
((A<String>::foo))
} else {
"abc"
})(A("OK"))