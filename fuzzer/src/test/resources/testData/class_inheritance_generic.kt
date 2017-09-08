interface Parent<T>
interface Simple
interface Foo<T, X, Y>

class Derived: Parent<Int>, Simple

interface Star<T : Star<T>>

class A<R>: Int by 1, String("abc"), Parent<Simple>