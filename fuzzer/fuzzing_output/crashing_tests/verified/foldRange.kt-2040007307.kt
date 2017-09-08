import kotlin.test.assertEquals
fun box(): (String)? {
val result = (1 .. 5).fold(0)((if (true) {
(({x, y -> x + y}))
} else {
(({x, y -> x + y}))
})!!)
assertEquals(15, result)
return "OK"
}