fun f() = ((123))

fun f() = false

fun f() = "abacaba"

fun f() = """xt\n"""

fun f() = 123L

fun f() = 123_456_L

fun f() = 0x123_4Ab

fun f() = 'a'

fun f() = 3.45e+123

fun f() = null

fun f() = this

fun f() = this@LABL

fun f() = super

fun f() = super<Int>@label

fun f() = super@labbel

fun f() = if (123) 123

fun f() = if ("abc") "xtz" else "qwe"

fun f() = when (123) {
    is Int -> 4
    !is Any? -> 5
    in 1..2 -> 3
    !in 1..a -> 6
    5 -> 2
    else -> 1
   }

fun f() = when {}

fun f() = try {}
            catch(x: Exception) {}
            finally {}

fun f() = object {}

fun f() = throw 123

fun f() = return null

fun f() = return@QWE

fun f() = continue

fun f() = break@xyz

fun f() = for (x in "abc") {}

fun f() = while(false) {}

fun f() = do {} while(true)

fun f(x: String): String = x

fun f() = { "abc" }

fun f() = for ((x, y: Int, z) in "abc") {}

fun f() = { -> 123 }

fun f() = {x, y -> 123 }