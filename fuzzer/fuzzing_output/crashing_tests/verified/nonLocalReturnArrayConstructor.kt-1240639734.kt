fun testArray(): Unit {
Array<String>(5)({i -> if (i == 3) {
return
}
i.toString()})
throw AssertionError()
}
tailrec fun testIntArray(): Unit {
IntArray(5)((if (true) {
({i -> if (i == 3) {
return
}
i})
} else {
({i -> if (i == 3) {
return
}
i})
}))
throw AssertionError()
}
fun box(): String {
testArray()
testIntArray()
return "OK"
}