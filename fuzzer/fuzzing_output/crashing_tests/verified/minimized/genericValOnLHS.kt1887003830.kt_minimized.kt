class Generic<P : Any>(val p: P)
class Host {
val v = "OK"
}
fun box(): String {
return (if (((Generic(Host()).p::v)) != ((Generic(Host()).p::v))) {
((Generic(Host()).p::v))
} else {

})()
}