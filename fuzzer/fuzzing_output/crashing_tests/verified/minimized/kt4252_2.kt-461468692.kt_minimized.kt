class Foo() {
companion object {
 val bar = "OK";
 var boo = "FAIL";
 }



val Any.c: String
var d: (String)?
init {
 c = bar
 d = Foo.bar
 boo = "O"
 Foo.boo += "K"
 }


}