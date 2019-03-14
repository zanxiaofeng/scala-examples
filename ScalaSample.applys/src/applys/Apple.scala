package applys

class Apple(val color: String) {
  override def toString() = { "there is a " + color + " apple!" }
}

object Apple {
  def apply(color: String) = {
    new Apple(color)
  }
}