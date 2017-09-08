fun box(): String {
val result = (((A::Inner))!!!!)((::A)(), 111).result + (A::Inner)(A(), 222).result
}