inline fun foo(f: ((Int) -> Int)) = (f)!!(0)
class Outer {
class Nested {
val y = foo({a -> a})
}
}