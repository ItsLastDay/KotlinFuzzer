class TestInitValFromParameter(val x: Int)
class TestInitValInClass {
val x = 0
}
class TestInitValInInitBlock {
val Any.x: Int
init {
 x = 0
 }

}