package types

class TestClass[T](var v: T) {

  def printself(v: TestClass[T]) {
    println(v)
  }

  def printself1(v: this.type) {
    println(v)
  }

  def printself2(v: TestClass.this.type) {
    println(v)
  }

  override def toString() = {
    v.toString
  }

}

class TestClass2 {
  def printSubClass1(t: this.TestSubClass) {
    val v = t.getClass();
    println(v.toString())
  }

  def printSubClass2(t: this.type#TestSubClass) {
    println(t.getClass().toString())
  }

  def getsub() = {
    val v = new TestSubClass();
    printSubClass1(v)
    printSubClass2(v)
    v
  }

  class TestSubClass {

  }
}