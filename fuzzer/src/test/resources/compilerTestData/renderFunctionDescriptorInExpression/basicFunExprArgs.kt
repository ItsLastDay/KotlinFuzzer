annotation class Ann(val x: String)

fun foo(block: (Int, String) -> Unit) = block.javaClass

fun box() {
    foo( @Ann("OK1") fun(@Ann("1") x: Int, @Ann("2") y: String) {})
}

//@Ann(x = "OK1") local final fun <no name provided>(/*0*/ @Ann(x = "1") x: kotlin.Int, /*1*/ @Ann(x = "2") y: kotlin.String): kotlin.Unit defined in box