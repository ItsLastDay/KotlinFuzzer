suspend inline fun <V> suspendHere(v: V): V = suspendCoroutineOrReturn((if (true) {
({x -> })
} else {
({x -> })
}))