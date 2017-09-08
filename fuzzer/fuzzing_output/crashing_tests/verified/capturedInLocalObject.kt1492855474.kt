fun test(): Unit {
var x = 0
run({val obj = object{
inline fun foo(): Unit {
(++ x)
}
}
obj.foo()})
}