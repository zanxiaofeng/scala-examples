package classes

import java.io.IOException

object TestClasses extends App {
  val c1 = new Cell1 { contents = 20 }
  println(c1.get)
  val c2 = new Cell2(30)
  println(c2.get)

  c1.set(21)
  println(c1.get)
  c2.set(31)
  println(c2.get)

  val dt = new Date(12, 12, 2012);
  dt output

  val today = Date(13, 12, 2012);
  today output

  today `how are you`

  var a = "192".toInt
  try {
    throw new IOException()

  } catch {
    case ex: IOException => println(ex)
  }

  var b: List[Int] = Nil
  b = 2 :: 3 :: Nil
  b = b.reverse

  def testOption(isNone: Boolean): Option[Int] = {
    if (isNone) None else Option(2)
  }
}