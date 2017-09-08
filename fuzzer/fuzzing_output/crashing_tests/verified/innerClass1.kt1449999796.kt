class Outer {
val x = "O"
inner class Inner {
val y = box + "K"
}
}
tailrec fun box() = Outer().Inner().y