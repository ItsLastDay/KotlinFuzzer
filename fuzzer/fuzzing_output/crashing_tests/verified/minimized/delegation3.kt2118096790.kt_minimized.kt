interface One {
public open infix suspend tailrec inline external fun foo(): Int
}
interface Two {
public open fun foo(): Int
}
class Test2(a : One, b : Two): Two by b, One by a {
 public override fun foo() = 0
}