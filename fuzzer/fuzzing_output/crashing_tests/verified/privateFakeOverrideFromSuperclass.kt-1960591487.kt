import kotlin.reflect.*
open class A(private val p: Int)
class B: A(42)


fun box() = if ((B)?::class.memberProperties.A()) {
"OK"
} else {
"Fail: invisible fake overrides should not appear in KClass.memberProperties"
}