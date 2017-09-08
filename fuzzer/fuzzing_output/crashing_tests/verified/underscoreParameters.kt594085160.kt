inline fun foo(block: ((String, (String)?, String) -> String)): (String)? = ((block) ?: (block))("O", "fail", "K")
fun box() = foo({x, _, y -> x + y})