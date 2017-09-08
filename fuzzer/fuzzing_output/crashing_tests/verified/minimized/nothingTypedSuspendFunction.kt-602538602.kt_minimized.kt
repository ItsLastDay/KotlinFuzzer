suspend fun suspendLogAndThrow(exception: Throwable): Nothing = suspendCoroutineOrReturn((if (true) {
({c -> })
} else {
({c -> })
}))