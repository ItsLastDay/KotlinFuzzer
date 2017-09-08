import kotlin.reflect.KType
fun unit(p: Unit): Unit {

}
suspend fun box(): (String)? {
fun check(t1: KType, t2: KType): Unit {

}
check((when {
(::unit) !in null -> (::unit)
else -> (::unit)
}).parameters.single().type, ::unit.returnType)
return "OK"
}