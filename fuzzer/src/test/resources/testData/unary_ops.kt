fun prefixOps() {
    fun foo() = -1
    fun foo() = labl@ ++ !5
    fun foo() = @Ann z
    fun foo() = @[Ann Nna] +z
    fun foo() = --z
}

fun postfixOps() {
    // Just callable references
    fun foo() = ::bar
    fun foo() = String::class
    fun foo() = Any?::ext

    // Real postfix ops
    fun foo() = 5++
    fun foo() = 6--
    fun foo() = null!!
    fun foo() = a?.map<Int> { it * 2 }.filter { it == 4 }
    fun foo() = bar{}<Any, Any>("qwe", *lst, x=5)
    fun foo() = ::arr[5, 6, 7][8]
}