package generics

class Column[T1](val name: String) {
  def ~[T2](o: Column[T2]) = {
    new Projection2(this, o)
  }
}

object Column {
  def apply[T](name: String) = {
    new Column[T](name)
  }
}
