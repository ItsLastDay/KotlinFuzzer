fun z() {}

fun foo(x: Int) {
    when {
        x == 21 -> z()
        x == 42 -> z()
        else -> {}
    }
}

// 0 GETSTATIC
