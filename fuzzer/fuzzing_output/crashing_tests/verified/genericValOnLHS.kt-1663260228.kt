class Generic<P : Any>(val p: P)
class Host {

 fun t() {}
 val v = "OK"

}
fun box(): String {
Generic(Host()).p::class
((((if ((Generic(Host()).p::t) == (Generic(Host()).p::t)) {
(Generic(Host()).p::t)
} else {
(Generic(Host()).p::t)
}) ?: (if ((Generic(Host()).p::t) == (Generic(Host()).p::t)) {
(Generic(Host()).p::t)
} else {
(Generic(Host()).p::t)
}))))()
return (Generic(Host()).p::v)()
}