public class Input(val s1: String, val s2: String) {

}
public inline fun <T, R> T.use(block: (() -> R)): R {
return (block)!!()
}
public inline fun Input.forEachLine(block: (() -> Unit)): Unit {
use({})
}