fun main() {
    val a = false
    val b = false
    val c = false
    if (a && b && c) {
        "then"
    } else {
        "else"
    }
}

// 3 ICONST_0
// 0 ICONST_1
// 3 IFEQ
// 0 IFNE
// 3 IF
// 1 GOTO