import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
suspend fun suspendLogAndThrow(exception: Throwable): Nothing = suspendCoroutineOrReturn((if (true) {
({c -> c.resumeWithException(exception)
COROUTINE_SUSPENDED})
} else {
({c -> c.resumeWithException(exception)
COROUTINE_SUSPENDED})
}))