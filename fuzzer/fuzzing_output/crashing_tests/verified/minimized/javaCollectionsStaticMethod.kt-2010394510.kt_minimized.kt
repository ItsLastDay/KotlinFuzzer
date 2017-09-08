import java.util.Collections
fun box(): String {
val numbers = ArrayList<Int>()
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