fun box(): String {
return doStuff((((String::capitalize)!!) ?: ((String::capitalize)!!)).apply({}))
}