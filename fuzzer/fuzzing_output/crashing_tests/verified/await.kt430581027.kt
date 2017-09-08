import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*
class Promise<T>(private val executor: ((T) -> Unit) -> Unit) {

 private var value: Any? = null
 private var thenList: MutableList<(T) -> Unit>? = mutableListOf()

 init {
 executor {
 value = it
 for (resolve in thenList!!) {
 resolve(it)
 }
 thenList = null
 }
 }

 fun <S> then(onFulfilled: (T) -> S): Promise<S> {
 return Promise { resolve ->
 if (thenList != null) {
 thenList!!.add { resolve(onFulfilled(it)) }
 }
 else {
 resolve(onFulfilled(value as T))
 }
 }
 }
}

// FILE: queue.kt
}
val queue = mutableListOf<(() -> Unit)>()
fun <T> postpone(computation: (() -> (T)?)): Promise<T> {
return Promise((if (true) {
({resolve -> queue += {resolve(computation())}})
} else {
({resolve -> queue += {resolve(computation())}})
}))
}
fun processQueue(): Unit {
while (queue.isNotEmpty()) {
queue.removeAt(0)()
}
}