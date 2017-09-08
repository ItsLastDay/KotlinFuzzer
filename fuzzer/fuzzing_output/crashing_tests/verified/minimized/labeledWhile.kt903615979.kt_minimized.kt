suspend infix fun suspendAndContinue(): Unit = suspendCoroutineOrReturn((if (true) {
({c -> })
} else {
({c -> })
}))