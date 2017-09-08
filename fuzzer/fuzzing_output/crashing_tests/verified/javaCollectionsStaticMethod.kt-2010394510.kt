import java.util.Collections
import java.util.ArrayList
fun box(): String {
val numbers = ArrayList<Int>()
numbers.add(1)
numbers.add(2)
numbers.add(3)
((when {
(Collections::rotate) in null -> (Collections::rotate)
else -> (Collections::rotate)
}))(numbers, 1)
return if ("$numbers" == "[3, 1, 2]") {
"OK"
} else {
"Fail $numbers"
}
}