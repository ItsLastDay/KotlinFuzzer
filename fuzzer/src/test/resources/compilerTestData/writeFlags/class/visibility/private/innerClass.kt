class Foo {
  private class MyClass() {
  }
}

// TESTED_OBJECT_KIND: class
// TESTED_OBJECTS: Foo$MyClass
// FLAGS: ACC_FINAL, ACC_SUPER
