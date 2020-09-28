package applys

class AppleFactory {
  def apply(color: String) = {
    Apple(color)
  }
}

object AppleFactory {
  def get = new AppleFactory()
}