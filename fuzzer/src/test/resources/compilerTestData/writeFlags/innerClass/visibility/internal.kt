class Foo {
  inner class MyClass() {
  }
}

// TESTED_OBJECT_KIND: innerClass
// TESTED_OBJECTS: Foo, MyClass
// FLAGS: ACC_FINAL, ACC_PUBLIC
