suspend fun bar(x: (Int)?): (Int)? = suspendCoroutine((if (true) {
({c -> })
} else {
({c -> })
}))