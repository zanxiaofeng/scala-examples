package cases

object TestCases extends App {
  //Case class needn't use new for primary constructor, because it create the compant object and apply unapply function
  val book1 = Book("HSCB", "123451", 12.23)
  println("Book 1: " + book1)

  val book2 = new Book("KJV", 100.23)

  println("Book 2: " + book2)
  val book3 = Book("NIV", "123453", 200.23)
  println("Book 3: " + book3)
  val book4 = Book("CSB", "123454", 300.23)
  println("Book 4: " + book4)

  val Book(bName1, bIsbn1, bPrice1) = book1
  println("Book 1: " + bName1 + ", " + bIsbn1 + ", " + bPrice1)

  val Book(bName2, bIsbn2, bPrice2) = book2
  println("Book 2: " + bName2 + ", " + bIsbn2 + ", " + bPrice2)

  printLargePrice(book1)
  printLargePrice(book2)
  printLargePrice(book3)
  printLargePrice(book4)
  printLargePrice(3)

  def printLargePrice(book: Any) {
    book match {
      case Book(name, isbn, price) if price > 200 => println("Large Price Book: " + name + ", " + isbn + ", " + price)
      case _ => println("Small Price Book")
    }
  }

  val sum = Sum(Sum(Number(1), Number(2)), Number(3))
  println("sum: " + sum.eval())
}

