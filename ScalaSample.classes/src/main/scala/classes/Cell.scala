package classes

class Cell1 {
  var contents: Int = 0

  def get = contents;
  def set(n: Int) = contents = n
}

class Cell2(var contents: Int) {
  def get = contents;
  def set(n: Int) = contents = n
}

class Cell3(private var contents: Int) {
  def this() = this(0)
  def get = contents;
  def set(n: Int) = contents = n
}