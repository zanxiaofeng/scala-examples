package cases

case class Book(var title: String, var ISBN: String, var price: Double) {
  def this(title: String, price: Double) {
    this(title, null, price)
  }

  override def toString() = {
    "Title: " + title + ", ISBN: " + ISBN + ", Price: " + price.toString
  }
}