fun box(): (String)? {
val a = intArrayOf(1, 2)
val b = arrayOf("OK")
if ((a::component2)() != 2)({return "fail"})
if ((try {
(a::get)(1) != 2
}
finally {
(a::get)(1) != 2
}))({return "fail"})
(return (if (true) {
((b::get))
} else {
((b::get))
}))!!(0)
}