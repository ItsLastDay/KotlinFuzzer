class G<T>
fun inNumber(): G<in Number> = null!!
fun box(): String {
val i = (when {
(::inNumber) !in null -> (::inNumber)
else -> (::inNumber)
}).returnType
return "OK"
}