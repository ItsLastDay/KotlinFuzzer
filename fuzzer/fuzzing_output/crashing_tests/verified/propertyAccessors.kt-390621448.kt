annotation class Get
annotation class Set
annotation class SetParam
var foo: String

 @Get get() = ""

 @Set set(@SetParam value) {}


inline external fun box(): String {
assert(::foo.getter.annotations.single() is Get)
assert(((::foo)!!)!!.setter.annotations.single() is Set)
assert(::foo.setter.parameters.single().annotations.single() is SetParam)
return "OK"
}