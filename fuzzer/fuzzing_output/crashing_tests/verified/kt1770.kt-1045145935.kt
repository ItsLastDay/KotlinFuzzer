import org.w3c.dom.Element
class MyElement(e: Element): Element by e {
 fun bar() = "OK"
}


fun box(): String {
val box = (MyElement)?::class.java
return "OK"
}