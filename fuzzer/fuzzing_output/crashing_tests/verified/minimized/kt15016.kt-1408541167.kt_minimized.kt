suspend fun suspendHere(): String = suspendCoroutineOrReturn((if (true) {
({Foo -> })
} else {
({Foo -> })
}))