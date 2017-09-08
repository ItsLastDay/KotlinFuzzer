public class Input(val s1: String, val s2: String) {

}
public inline fun <T, R> T.use(block: ((T) -> R)): R {
return (block)!!(this)
}
public inline fun Input.useLines(block2: ((Iterator<String>) -> Unit)): Unit {
this.use({})
}