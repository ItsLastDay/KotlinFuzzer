class Generic<P : Any>(val p: P)
class Host {
fun t(): Unit {

}
val v = "OK"
}
fun box(): String {
((when {
(Generic(Host()).p::t) !in null -> (Generic(Host()).p::t)
else -> (Generic(Host()).p::t)
}))()
return (Generic(Host()).p::v)()
}