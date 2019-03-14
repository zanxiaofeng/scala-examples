package classes.implicits

object TestImplicits extends App {
  val x = Array(2, 3, 1, 4)
  println("x = " + x.sort((x: Int, y: Int) => x < y))
}