import kotlin.reflect.*
class C {

 fun foo() {}
 val bar = 42

}
val C_fooReflect = C::class.functions.find({it.name == "foo"})!!
val C_foo = (C)?::foo
val cFoo = C()