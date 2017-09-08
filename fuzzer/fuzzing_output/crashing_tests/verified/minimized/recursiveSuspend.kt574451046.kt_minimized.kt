suspend fun suspendHere(value: Int): Int = suspendCoroutineOrReturn((if (true) {
({x -> })
} else {
({x -> })
}))