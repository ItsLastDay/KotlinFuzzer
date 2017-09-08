class Generic<P : Any>(val p: P)
class Host {

 fun t() {}
 val v = "OK"

}
fun box(): String {
Generic(Host()).p::class
(Generic(Host()).p::t)()
return (if (((Generic(Host()).p::v)) != ((Generic(Host()).p::v))) {
((Generic(Host()).p::v))
} else {
1
})()
}