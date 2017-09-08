enum final class E {

 I

}
fun box(): String {
val i = (when {
((E::name)) !in null -> ((E::name))
else -> ((E::name))
}).get(E.I)
if (i != "I") {
return "Fail $i"
}
val n = (E::ordinal).get(E.I)
if (n != 0) {
return "Fail $n"
}
return "OK"
}