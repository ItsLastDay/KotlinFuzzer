import kotlin.reflect.jvm.isAccessible
class Result {

 public val value: String = "OK"

}
fun box(): String {
val p = (Result)?::value
p.isAccessible = false
return p.get(Result())
}