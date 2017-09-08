fun box(): (String)? {
return invoker({"OK"})
}
inline tailrec fun invoker(gen: (() -> String)): String {
return (gen)!!()
}