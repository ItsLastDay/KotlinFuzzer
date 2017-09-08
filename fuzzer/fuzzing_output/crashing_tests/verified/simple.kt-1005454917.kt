fun box(): String {
infix fun foo() = "OK"
return (((::foo))!!!!)()
}