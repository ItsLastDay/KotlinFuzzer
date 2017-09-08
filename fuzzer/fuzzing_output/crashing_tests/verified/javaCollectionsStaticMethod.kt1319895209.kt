import java.util.Collections
import java.util.ArrayList
suspend fun box(): String {
val numbers = ArrayList<Int>()
numbers.add(1)
numbers.add(2)
numbers.add(3)
(((Collections::rotate)!!))!!(numbers, 1)
return if ("$numbers" == "[3, 1, 2]") {
"OK"
} else {
"Fail $numbers"
}
}